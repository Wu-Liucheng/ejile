package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.AdminMapper;
import xyz.somedefinitions.ejile.dao.BusinessMapper;
import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.Business;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.entity.SuperAdmin;
import xyz.somedefinitions.ejile.service.AdminService;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Resource
    BusinessMapper businessMapper;

    @Override
    public RequestResult<Admin> adminLogin(Admin admin) {
        Admin adm = adminMapper.selectByUsernameAndPassword(admin);
        if(adm!=null){
            if(adm.getAuthority()!=0){
                return new RequestResult<>(true,adm,"");
            }
            else {
                return new RequestResult<>(true,new SuperAdmin(adm,businessMapper.selectAll()),"");
            }
        }
        else {
            return new RequestResult<>(false,adm,"");
        }
    }

    @Transactional
    @Override
    public RequestResult<Void> addAdmin(@NotNull Admin admin) {
        if(admin.getBusinessId()==null){
            return new RequestResult<>(false,null,"没有所属商家名称！");
        }
        Business business = businessMapper.selectByPrimaryKey(admin.getBusinessId());
        if(business==null)
            return new RequestResult<>(false,null,"没有这个商家");
        Admin admin1 = adminMapper.selectByUsername(admin.getUsername());
        if(admin1!=null){
            return new RequestResult<>(false,null,"用户名冲突！");
        }
        admin.setAuthority(1);
        admin.setCreateTime(LocalDate.now());
        admin.setUpdateTime(LocalDate.now());
        if(adminMapper.insert(admin)>0){
            return new RequestResult<>(true,null,"");
        }
        else {
            return new RequestResult<>(false,null,"");
        }
    }

    @Transactional
    @Override
    public RequestResult<Void> deleteAdmin(Admin admin) {
        if(admin.getId()==null){
            return new RequestResult<>(false,null,"没有该管理员");
        }
        int res = adminMapper.deleteByPrimaryKey(admin.getId());
        if(res>0){
            return new RequestResult<>(true,null,"已删除。");
        }
        else {
            return new RequestResult<>(false,null,"");
        }
    }

    @Transactional
    @Override
    public RequestResult<Void> updateAdminPassword(Admin admin) {
        if(admin.getId()==null){
            return new RequestResult<>(false,null,"没有该管理员");
        }
        int res = adminMapper.updatePassword(admin);
        if(res>0){
            return new RequestResult<>(true,null,"已更新。");
        }
        else {
            return new RequestResult<>(false,null,"");
        }
    }

    @Override
    public RequestResult<List<Admin>> listOfOneBusinessAdmin(Integer businessId) {
        return new RequestResult<>(true,adminMapper.selectByBusinessId(businessId),"");
    }
}
