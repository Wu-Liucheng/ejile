package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.*;
import xyz.somedefinitions.ejile.entity.Business;

@Mapper
public interface BusinessMapper {
    @Select("select * from business where id = #{id}")
    Business selectByPrimaryKey(Integer id);

    @Select("select * from business where id =  #{id}")
    @Results(id="id",value = {
            @Result(column = "id",property = "categories",
            many = @Many(select = "xyz.somedefinitions.ejile.dao.CategoryMapper.selectByBusinessIdWithCommoditiesInfo"))
    })
    Business selectByPrimaryKeyWithCategoriesInfo(Integer id);

    @Select("select * from business where id = #{id}")
    Business selectByPrimaryKeyWithAdminsInfo(Integer id);
}
