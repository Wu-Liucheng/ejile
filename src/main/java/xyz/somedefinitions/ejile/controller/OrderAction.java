package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.somedefinitions.ejile.service.OrderDetailService;
import xyz.somedefinitions.ejile.service.OrderService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/order")
public class OrderAction {
    @Resource
    OrderService orderService;

    @Resource
    OrderDetailService orderDetailService;
}
