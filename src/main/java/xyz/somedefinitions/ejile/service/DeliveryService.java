package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Delivery;
import xyz.somedefinitions.ejile.entity.RequestResult;

public interface DeliveryService {
    RequestResult<Delivery> login(Delivery delivery);
    RequestResult<Void> add(Delivery delivery);
    RequestResult<Void> update(Delivery delivery);
}
