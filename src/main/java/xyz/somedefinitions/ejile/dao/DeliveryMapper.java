package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.somedefinitions.ejile.entity.Delivery;

@Mapper
public interface DeliveryMapper {
    @Select("select * from delivery where id=#{id}")
    Delivery selectByPrimaryKey(Integer id);

    @Select("select * from delivery where username= #{username} and password= #{password}")
    Delivery selectByUsernameAndPassword(Delivery delivery);

    @Select("select id from delivery where username= #{username}")
    Delivery selectByUsername(String username);

    @Select("select id from delivery where mobile= #{mobile}")
    Delivery selectByMobile(String mobile);

    @Insert("insert into delivery(username,password,mobile,address,balance,createTime,updateTime) values " +
            "(#{username},#{password},#{mobile},#{address},#{balance},#{createTime},#{updateTime});")
    int insert(Delivery delivery);

    @Update("update delivery set address=#{address},updateTime=#{updateTime} where id=#{id}")
    int update(Delivery delivery);

    @Update("update delivery set balance=#{balance} where id=#{id}")
    int updateBalance(Delivery delivery);
}
