package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Business;
import xyz.somedefinitions.ejile.entity.RequestResult;

public interface BusinessService {
    RequestResult<Void> add(Business business);
    RequestResult<Void> delete(Integer id);
    RequestResult<Void> update(Business business);
}
