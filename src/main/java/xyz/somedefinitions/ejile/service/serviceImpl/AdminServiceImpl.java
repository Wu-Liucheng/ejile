package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.AdminDao;
import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.AdminService;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    public RequestResult<Admin> adminLogin(Admin admin) {
        return new RequestResult<>(false,adminDao.selectByUsernameAndPassword(admin),"");
    }
}
