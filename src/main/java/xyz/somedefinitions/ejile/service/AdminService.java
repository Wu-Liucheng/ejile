package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.RequestResult;

import java.util.List;

public interface AdminService {
    RequestResult<Admin> adminLogin(Admin admin);
    RequestResult<Void> addAdmin(Admin admin);
    RequestResult<Void> deleteAdmin(Admin admin);
    RequestResult<Void> updateAdminPassword(Admin admin);
    RequestResult<List<Admin>> listOfOneBusinessAdmin(Integer businessId);
}
