package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.somedefinitions.ejile.entity.Business;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.BusinessService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/business")
public class BusinessAction {
    @Resource
    BusinessService businessService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> addBusiness(@RequestBody @Valid Business business){
        return businessService.add(business);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> deleteBusiness(@RequestParam(value = "id") Integer id){
        return businessService.delete(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> updateInfo(@RequestBody @Valid Business business){
        return businessService.update(business);
    }

    @RequestMapping(value = "/select-all",method = RequestMethod.GET)
    @ResponseBody
    public RequestResult<List<Business>> listAll(){
        return businessService.listAll();
    }
}
