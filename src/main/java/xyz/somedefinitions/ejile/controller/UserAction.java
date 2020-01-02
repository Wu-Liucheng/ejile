package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.somedefinitions.ejile.service.UserService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class UserAction {
    @Resource
    UserService userService;
}
