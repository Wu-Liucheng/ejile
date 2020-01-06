package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Business;
import xyz.somedefinitions.ejile.entity.RequestResult;

import java.util.List;

public interface BusinessService {
    RequestResult<Void> add(Business business);
    RequestResult<Void> delete(Integer id);
    RequestResult<Void> update(Business business);
    RequestResult<List<Business>> listAll();
}
