package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.CommodityMapper;
import xyz.somedefinitions.ejile.service.CommodityService;

import javax.annotation.Resource;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    CommodityMapper commodityMapper;
}
