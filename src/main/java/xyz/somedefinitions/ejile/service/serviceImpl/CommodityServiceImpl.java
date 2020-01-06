package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.AdminMapper;
import xyz.somedefinitions.ejile.dao.CategoryMapper;
import xyz.somedefinitions.ejile.dao.CommodityMapper;
import xyz.somedefinitions.ejile.entity.Admin;
import xyz.somedefinitions.ejile.entity.Category;
import xyz.somedefinitions.ejile.entity.Commodity;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.CommodityService;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    CommodityMapper commodityMapper;

    @Resource
    CategoryMapper categoryMapper;

    @Resource
    AdminMapper adminMapper;

    @Override
    public RequestResult<List<Commodity>> listAllOfOneCategory(Integer categoryId) {
        return new RequestResult<>(true,commodityMapper.selectByCategoryId(categoryId),"");
    }

    @Transactional
    @Override
    public RequestResult<Void> add(Commodity commodity) {
        Category category = categoryMapper.selectByPrimaryKey(commodity.getCategoryId());
        if(category==null){
            return new RequestResult<>(false,null,"没有这个商品分类！");
        }
        Admin admin = adminMapper.selectByPrimaryKey(commodity.getCreateId());
        if(admin == null){
            return new RequestResult<>(false,null,"没有该管理员！");
        }
        commodity.setUpdateId(commodity.getCreateId());
        commodity.setStatus(true);
        commodity.setCreateTime(LocalDate.now());
        commodity.setUpdateTime(LocalDate.now());
        return new RequestResult<>(commodityMapper.insert(commodity)>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> delete(Integer id) {
        return new RequestResult<>(commodityMapper.delete(id)>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> update(Commodity commodity) {
        if(commodity.getId()==null){
            return new RequestResult<>(false,null,"没有商品ID");
        }
        Commodity commodity1 = commodityMapper.selectByPrimaryKey(commodity.getCreateId());
        if(commodity1==null){
            return new RequestResult<>(false,null,"没有该商品！");
        }
        if(commodity.getName()!=null&&!commodity.getName().equals("")){
            commodity1.setName(commodity.getName());
        }
        if(commodity.getImageUrl()!=null&&!commodity.getImageUrl().equals("")){
            commodity1.setImageUrl(commodity.getImageUrl());
        }
        if(commodity.getDescription()!=null&&!commodity.getDescription().equals("")){
            commodity1.setDescription(commodity.getDescription());
        }
        if(commodity.getPrice()!=null&&!(commodity.getPrice()==0)){
            commodity1.setPrice(commodity.getPrice());
        }
        if(commodity.getUnit()!=null&&!commodity.getUnit().equals("")){
            commodity1.setUnit(commodity.getUnit());
        }
        commodity1.setUpdateTime(LocalDate.now());
        return new RequestResult<>(commodityMapper.update(commodity1)>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> updateStock(Integer stock, Integer id) {
        Commodity commodity = commodityMapper.selectByPrimaryKey(id);
        if (commodity == null) {
            return new RequestResult<>(false,null,"没有该商品！");
        }
        commodity.setStock(stock);
        return new RequestResult<>(commodityMapper.updateStock(commodity)>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> updateSales(Integer increment, Integer id) {
        Commodity commodity = commodityMapper.selectByPrimaryKey(id);
        if (commodity == null) {
            return new RequestResult<>(false,null,"没有该商品！");
        }
        commodity.setSales(commodity.getSales()+increment);
        return new RequestResult<>(commodityMapper.updateStock(commodity)>0,null,"");
    }
}
