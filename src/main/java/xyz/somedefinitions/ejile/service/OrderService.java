package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Order;
import xyz.somedefinitions.ejile.entity.RequestResult;

public interface OrderService {
    RequestResult<Order> create(Order order);
    RequestResult<Void> pay(String number,String username,String password);
    RequestResult<Void> delivery(String number,Integer id);
    RequestResult<Void> finish(String number,Integer id);
}
