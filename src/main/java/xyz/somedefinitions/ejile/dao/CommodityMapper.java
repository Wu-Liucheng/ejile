package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.somedefinitions.ejile.entity.Commodity;

import java.util.List;

@Mapper
public interface CommodityMapper {
    @Select("select * from commodity where id = #{id}")
    Commodity selectByPrimaryKey(Integer id);

    @Select("select * from commodity where id = #{id}")
    Commodity selectByPrimaryKeyWithCategoryInfo(Integer id);

    @Select("select * from commodity where categoryId = #{id}")
    List<Commodity> selectByCategoryId(Integer id);
}
