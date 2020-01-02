package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.*;
import xyz.somedefinitions.ejile.entity.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category where id = #{id}")
    Category selectByPrimaryKey(Integer id);

    @Select("select * from category where id = #{id}")
    Category selectByPrimaryKeyWithBusinessInfo(Integer id);

    @Select("select * from category where id = #{id}")
    Category selectByPrimaryKeyWithCommoditiesInfo(Integer id);

    @Select("select * from category where id = #{id}")
    Category selectByPrimaryKeyWithBusinessAndCommoditiesInfo(Integer id);

    @Select("select * from category where businessId = #{id}")
    List<Category> selectByBusinessId(Integer id);

    @Select("select * from category where businessId = #{id}")
    @Results(id="id",value = {
            @Result(column = "id",property = "commodities",
                    many = @Many(select = "xyz.somedefinitions.ejile.dao.CommodityMapper.selectByCategoryId"))
    })
    List<Category> selectByBusinessIdWithCommoditiesInfo(Integer id);
}
