package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.entity.User;
import xyz.somedefinitions.ejile.service.UserService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserAction {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<User> login(@RequestBody @Valid User user){
        return userService.login(user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> register(@RequestBody @Valid User user){
        return userService.add(user);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> update(@RequestBody @Valid User user){
        return userService.update(user);
    }
}
