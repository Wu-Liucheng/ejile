package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.DeliveryMapper;
import xyz.somedefinitions.ejile.entity.Delivery;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.DeliveryService;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Resource
    DeliveryMapper deliveryMapper;

    @Override
    public RequestResult<Delivery> login(Delivery delivery) {
        Delivery delivery1 = deliveryMapper.selectByUsernameAndPassword(delivery);
        return new RequestResult<>(delivery1!=null,delivery1,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> add(Delivery user) {
        Delivery delivery1 = deliveryMapper.selectByUsername(user.getUsername());
        if (delivery1 != null) {
            return new RequestResult<>(false,null,"用户名冲突！");
        }
        Delivery user2 = deliveryMapper.selectByMobile(user.getMobile());
        if (user2 != null) {
            return new RequestResult<>(false,null,"手机号被占用！");
        }
        user.setCreateTime(LocalDate.now());
        user.setUpdateTime(LocalDate.now());
        user.setBalance(0);
        int r = deliveryMapper.insert(user);
        return new RequestResult<>(r>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> update(Delivery user) {
        Delivery u = deliveryMapper.selectByPrimaryKey(user.getId());
        if (u == null) {
            return new RequestResult<>(false,null,"没有该用户！");
        }

        if (user.getAddress() != null && !user.getAddress().equals("")) {
            u.setAddress(user.getAddress());
        }
        u.setUpdateTime(LocalDate.now());
        int r = deliveryMapper.update(u);
        return new RequestResult<>(r>0,null,"");
    }
}
