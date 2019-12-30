package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.AdminMapper;
import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.AdminService;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Override
    public RequestResult<Admin> adminLogin(Admin admin) {
        Admin adm = adminMapper.selectByUsernameAndPassword(admin);
        return new RequestResult<>(admin!=null,admin,"");
    }
}
