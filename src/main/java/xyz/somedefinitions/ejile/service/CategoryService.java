package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Category;
import xyz.somedefinitions.ejile.entity.RequestResult;

import java.util.List;

public interface CategoryService {
    RequestResult<List<Category>> listAllOfOneBusiness(Integer businessId);
    RequestResult<Void> add(Category category);
    RequestResult<Void> delete(Integer id);
    RequestResult<Void> update(Category category);
}
