package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.service.OrderService;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderService orderService;
}
