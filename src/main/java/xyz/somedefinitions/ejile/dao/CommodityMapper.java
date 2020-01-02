package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.somedefinitions.ejile.entity.Commodity;

@Mapper
public interface CommodityMapper {
    @Select("select * from commodity where id = #{id}")
    Commodity selectByPrimaryKey(Integer id);

    @Select("select * from commodity where id = #{id}")
    Commodity selectByPrimaryKeyWithCategoryInfo(Integer id);

    @Select("select * from commodity where categoryId = #{id}")
    Commodity selectByCategoryId(Integer id);
}
