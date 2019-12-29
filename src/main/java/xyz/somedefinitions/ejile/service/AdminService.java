package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.RequestResult;

public interface AdminService {
    RequestResult<Admin> adminLogin(Admin admin);
}
