package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import xyz.somedefinitions.ejile.entity.Admin;

import java.time.LocalDate;

@Mapper
public interface AdminMapper {
    @Select("select id,username,authority from admin where username = #{username} and password = #{password}")
    @Results(
            id = "id",
            value = {
                    @Result(column = "id", property = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
                    @Result(column = "username", property = "username", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "password", property = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
                    @Result(column = "authority", property = "authority",javaType = Integer.class, jdbcType = JdbcType.INTEGER),
                    @Result(column = "businessId", property = "businessId", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
                    @Result(column = "createTime",property = "createTime",javaType = LocalDate.class,jdbcType = JdbcType.DATE),
                    @Result(column = "updateTime",property = "updateTime",javaType = LocalDate.class,jdbcType = JdbcType.DATE),
            }
    )
    Admin selectByUsernameAndPassword(Admin admin);
}