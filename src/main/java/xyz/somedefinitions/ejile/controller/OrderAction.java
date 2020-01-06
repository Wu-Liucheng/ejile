package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.somedefinitions.ejile.entity.Order;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.OrderService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/order")
public class OrderAction {
    @Resource
    OrderService orderService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Order> create(@RequestBody @Valid Order order){
        return orderService.create(order);
    }

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> pay(@RequestParam(value="number") String number,
                                   @RequestParam(value="username") String username,
                                   @RequestParam(value = "password") String password){
        return orderService.pay(number, username, password);
    }

    @RequestMapping(value = "/delivery",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> delivery(@RequestParam(value = "number") String number,
                                        @RequestParam(value = "deliveryId") Integer id){
        return orderService.delivery(number, id);
    }

    @RequestMapping(value = "/finish",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> finish(@RequestParam(value = "number") String number,
                                      @RequestParam(value = "deliveryId") Integer id){
        return orderService.finish(number, id);
    }
}
