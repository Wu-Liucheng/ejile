package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.DeliveryMapper;
import xyz.somedefinitions.ejile.service.DeliveryService;

import javax.annotation.Resource;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Resource
    DeliveryMapper deliveryMapper;
}
