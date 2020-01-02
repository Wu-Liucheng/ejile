package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.somedefinitions.ejile.service.CommodityService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/commodity")
public class CommodityAction {
    @Resource
    CommodityService commodityService;
}
