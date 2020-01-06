package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.somedefinitions.ejile.entity.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User selectByPrimaryKey(Integer id);

    @Select("select * from user where username= #{username} and password= #{password}")
    User selectByUsernameAndPassword(User user);

    @Select("select id from user where username= #{username}")
    User selectByUsername(String username);

    @Select("select id from user where mobile= #{mobile}")
    User selectByMobile(String mobile);

    @Insert("insert into user(username,password,nickname,mobile,address,balance,createTime,updateTime) values " +
            "(#{username},#{password},#{nickname},#{mobile},#{address},#{balance},#{createTime},#{updateTime});")
    int insert(User user);

    @Update("update user set nickname=#{nickname},address=#{address},updateTime=#{updateTime} where id=#{id}")
    int update(User user);

    @Update("update user set balance=#{balance} where id=#{id}")
    int updateBalance(User user);

}
