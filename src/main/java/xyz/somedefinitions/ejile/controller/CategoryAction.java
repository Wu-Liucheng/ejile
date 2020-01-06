package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.somedefinitions.ejile.entity.Category;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.CategoryService;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryAction {
    @Resource
    CategoryService categoryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RequestResult<List<Category>> list(@RequestParam(value="businessId") Integer businessId){
        return categoryService.listAllOfOneBusiness(businessId);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> add(@RequestBody @Valid Category category){
        return categoryService.add(category);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> delete(@RequestParam(value = "id") @NotNull Integer id){
        return categoryService.delete(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> update(@RequestBody @Valid Category category){
        return categoryService.update(category);
    }
}
