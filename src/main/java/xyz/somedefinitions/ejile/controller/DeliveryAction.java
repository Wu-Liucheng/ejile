package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.somedefinitions.ejile.service.DeliveryService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/delivery")
public class DeliveryAction {
    @Resource
    DeliveryService deliveryService;
}
