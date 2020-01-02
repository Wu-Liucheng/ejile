package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.*;
import xyz.somedefinitions.ejile.entity.Business;

import java.util.List;

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

    @Select("select * from business")
    @Results(value = {
            @Result(column = "id",property = "admins",
                    many = @Many(select = "xyz.somedefinitions.ejile.dao.AdminMapper.selectByBusinessId"))
    })
    List<Business> selectAll();

    @Insert("insert into business(number,name,description,imageUrl,address,balance,mobile,createTime," +
            "updateTime) values(#{number},#{name},#{description},#{imageUrl},#{address},#{balance}," +
            "#{mobile},#{createTime},#{updateTime});")
    int insert(Business business);

    @Delete("delete from business where id = #{id};")
    int delete(Integer id);

    //需要先查找出原来的值，避免将不需要更改的字段设置为null
    @Update("update business set name=#{name},description=#{description},imageUrl=#{imageUrl}," +
            "address=#{address},mobile=#{mobile},updateTime=#{updateTime} where id=#{id};")
    int update(Business business);

    @Update("update business set balance=#{balance} where id=#{id};")
    int updateBalance(Business business);
}
