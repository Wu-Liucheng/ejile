package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Commodity;
import xyz.somedefinitions.ejile.entity.RequestResult;

import java.util.List;

public interface CommodityService {
    RequestResult<List<Commodity>> listAllOfOneCategory(Integer categoryId);
    RequestResult<Void> add(Commodity commodity);
    RequestResult<Void> delete(Integer id);
    RequestResult<Void> update(Commodity commodity);
    RequestResult<Void> updateStock(Integer stock,Integer id);
    RequestResult<Void> updateSales(Integer increment,Integer id);
}
