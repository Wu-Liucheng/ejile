package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.somedefinitions.ejile.entity.Delivery;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.DeliveryService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/delivery")
public class DeliveryAction {
    @Resource
    DeliveryService deliveryService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Delivery> login(@RequestBody @Valid Delivery delivery){
        return deliveryService.login(delivery);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> register(@RequestBody @Valid Delivery delivery){
        return deliveryService.add(delivery);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> update(@RequestBody @Valid Delivery delivery){
        return deliveryService.update(delivery);
    }
}
