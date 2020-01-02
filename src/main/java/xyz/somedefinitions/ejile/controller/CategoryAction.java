package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.somedefinitions.ejile.service.CategoryService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/category")
public class CategoryAction {
    @Resource
    CategoryService categoryService;
}
