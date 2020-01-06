package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.somedefinitions.ejile.entity.Commodity;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.CommodityService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/commodity")
public class CommodityAction {
    @Resource
    CommodityService commodityService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RequestResult<List<Commodity>> list(@RequestParam(value = "categoryId") Integer categoryId){
        return commodityService.listAllOfOneCategory(categoryId);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> insert(@RequestBody @Valid Commodity commodity){
        return commodityService.add(commodity);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> delete(@RequestParam(value = "id") Integer id){
        return commodityService.delete(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> update(@RequestBody @Valid Commodity commodity){
        return commodityService.update(commodity);
    }
}
