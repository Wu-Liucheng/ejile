package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.BusinessMapper;
import xyz.somedefinitions.ejile.dao.CategoryMapper;
import xyz.somedefinitions.ejile.entity.Business;
import xyz.somedefinitions.ejile.entity.Category;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.CategoryService;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    @Resource
    BusinessMapper businessMapper;

    @Override
    public RequestResult<List<Category>> listAllOfOneBusiness(Integer businessId) {
        return new RequestResult<>(true,categoryMapper.selectByBusinessId(businessId),"");
    }

    @Transactional
    @Override
    public RequestResult<Void> add(Category category) {
        Business business = businessMapper.selectByPrimaryKey(category.getBusinessId());
        if(business==null){
            return new RequestResult<>(false,null,"");
        }
        category.setCreateTime(LocalDate.now());
        category.setUpdateTime(LocalDate.now());
        int r = categoryMapper.insert(category);
        return new RequestResult<>(r>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> delete(Integer id) {
        return new RequestResult<>(categoryMapper.delete(id)>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> update(Category category) {
        if(category.getId()==null){
            return new RequestResult<>(false,null,"id为空！");
        }
        Category category1 = categoryMapper.selectByPrimaryKey(category.getId());
        if(category1==null){
            return new RequestResult<>(false,null,"没有该分类！");
        }
        if(category.getName()!=null&&!category.getName().equals("")){
            category1.setName(category.getName());
        }
        if(category.getImageUrl()!=null&&!category.getImageUrl().equals("")){
            category1.setImageUrl(category.getImageUrl());
        }
        category1.setUpdateTime(LocalDate.now());
        return new RequestResult<>(categoryMapper.update(category1)>0,null,"");
    }
}
