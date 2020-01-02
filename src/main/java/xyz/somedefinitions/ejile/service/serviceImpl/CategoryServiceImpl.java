package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.CategoryMapper;
import xyz.somedefinitions.ejile.service.CategoryService;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;
}
