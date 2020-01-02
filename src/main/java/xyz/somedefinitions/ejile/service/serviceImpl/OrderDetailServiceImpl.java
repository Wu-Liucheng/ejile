package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.OrderDetailMapper;
import xyz.somedefinitions.ejile.service.OrderDetailService;

import javax.annotation.Resource;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    OrderDetailMapper orderDetailMapper;
}
