package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.BusinessMapper;
import xyz.somedefinitions.ejile.entity.Business;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.BusinessService;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    BusinessMapper businessMapper;

    @Transactional
    @Override
    public RequestResult<Void> add(Business business) {
        business.setNumber(UUID.randomUUID().toString());
        business.setBalance(0);
        business.setCreateTime(LocalDate.now());
        business.setUpdateTime(LocalDate.now());
        if(businessMapper.insert(business)>0){
            return new RequestResult<>(true,null,"");
        }
        else {
            return new RequestResult<>(false,null,"发生了错误。");
        }
    }

    @Transactional
    @Override
    public RequestResult<Void> delete(Integer id) {
        int r = businessMapper.delete(id);
        return new RequestResult<>(r>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> update(Business business) {
        Business business1 = businessMapper.selectByPrimaryKey(business.getId());
        if(business.getName()!=null){
            business1.setName(business.getName());
        }
        if(business.getDescription()!=null){
            business1.setDescription(business.getDescription());
        }
        if(business.getImageUrl()!=null){
            business1.setImageUrl(business.getImageUrl());
        }
        if(business.getAddress()!=null){
            business1.setAddress(business.getAddress());
        }
        if(business.getMobile()!=null){
            business1.setMobile(business.getMobile());
        }
        business1.setUpdateTime(LocalDate.now());
        int r = businessMapper.update(business1);
        return new RequestResult<>(r>0,null,"");
    }

    @Override
    public RequestResult<List<Business>> listAll() {
        return new RequestResult<>(true,businessMapper.selectAllWithNothing(),"");
    }
}
