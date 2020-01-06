package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.*;
import xyz.somedefinitions.ejile.entity.*;
import xyz.somedefinitions.ejile.service.OrderService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderDetailMapper orderDetailMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    DeliveryMapper deliveryMapper;

    @Resource
    BusinessMapper businessMapper;

    @Transactional
    @Override
    public RequestResult<Order> create(Order order) {
        List<OrderDetail> details = order.getOrderDetails();
        String number = order.getUserId()+ Timestamp.valueOf(LocalDateTime.now()).getTime()+"";
        int sum = 0;
        for (OrderDetail orderDetail:
             details) {
            orderDetail.setOrderNumber(number);
            sum+=orderDetail.getAmount();
            orderDetailMapper.insert(orderDetail);
        }
        order.setNumber(number);
        order.setAmount(sum);
        order.setStatus(0);
        order.setCreateTime(LocalDate.now());
        order.setUpdateTime(LocalDate.now());
        int r = orderMapper.insert(order);
        return new RequestResult<>(r>0,order,null);
    }

    @Transactional
    @Override
    public RequestResult<Void> pay(String number, String username, String password) {
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);
        User user = userMapper.selectByUsernameAndPassword(user1);
        if(user==null){
            return new RequestResult<>(false,null,"密码错误！");
        }
        Order order = orderMapper.selectByPrimaryKey(number);
        if(order.getAmount()+200>user.getBalance()){
            return new RequestResult<>(false,null,"余额不足！");
        }
        user.setBalance(user.getBalance()-order.getAmount()-200);
        userMapper.updateBalance(user);
        int r = orderMapper.updateOrderStatus1(order.getNumber());
        return new RequestResult<>(r>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> delivery(String number, Integer id) {
        Order o = orderMapper.selectByPrimaryKey(number);
        if(o.getStatus()!=1){
            return new RequestResult<>(false,null,"抢单失败！");
        }
        Order order = new Order();
        order.setNumber(number);
        order.setDeliveryId(id);
        int r = orderMapper.updateOrderStatus2(order);
        return new RequestResult<>(r>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> finish(String number, Integer id) {
        Order order = orderMapper.selectByPrimaryKey(number);
        if(order==null||!order.getDeliveryId().equals(id)){
            return new RequestResult<>(false,null,null);
        }
        Business business = businessMapper.selectByPrimaryKey(order.getBusinessId());
        Delivery delivery = deliveryMapper.selectByPrimaryKey(order.getDeliveryId());
        order.setStatus(3);
        int r = orderMapper.updateOrderStatus3(order.getNumber());
        business.setBalance(business.getBalance()+order.getAmount());
        businessMapper.updateBalance(business);
        delivery.setBalance(delivery.getBalance()+200);
        deliveryMapper.updateBalance(delivery);
        return new RequestResult<>(r>0,null,"");
    }
}
