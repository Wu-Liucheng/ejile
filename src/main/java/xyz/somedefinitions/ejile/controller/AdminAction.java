package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.AdminService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminAction {
    @Resource
    AdminService adminService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Admin> login(@RequestBody @Valid Admin admin){
        return adminService.adminLogin(admin);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> add(@RequestBody @Valid Admin admin){
        return adminService.addAdmin(admin);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> delete(@RequestBody @Valid Admin admin){
        return adminService.deleteAdmin(admin);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> updatePassword(@RequestBody @Valid Admin admin){
        return adminService.updateAdminPassword(admin);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RequestResult<List<Admin>> listOfAdmins(@RequestParam (value = "businessId") Integer businessId){
        return null;
    }
}
