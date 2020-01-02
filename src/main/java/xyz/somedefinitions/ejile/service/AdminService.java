package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.RequestResult;

public interface AdminService {
    RequestResult<Admin> adminLogin(Admin admin);
    RequestResult<Void> addAdmin(Admin admin);
    RequestResult<Void> deleteAdmin(Admin admin);
    RequestResult<Void> updateAdminPassword(Admin admin);
}
