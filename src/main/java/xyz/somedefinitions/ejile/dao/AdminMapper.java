package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xyz.somedefinitions.ejile.entity.Admin;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select id,username,authority,businessId from admin where username = #{username} and password = #{password}")
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
                    @Result(column = "businessId", property = "business", javaType = Integer.class, jdbcType = JdbcType.INTEGER,
                            one=@One(select = "xyz.somedefinitions.ejile.dao.BusinessMapper.selectByPrimaryKeyWithCategoriesInfo")),
            }
    )
    Admin selectByUsernameAndPassword(Admin admin);

    @Select("select id,username,authority,businessId from admin where businessId = #{id}")
    List<Admin> selectByBusinessId(Integer id);

    @Select("select id from admin where username = #{username}")
    Admin selectByUsername(String username);

    @Insert("insert into admin(username,password,authority,businessId,createTime,updateTime) " +
            "values(#{username},#{password},#{authority},#{businessId},#{createTime},#{updateTime});")
    int insert(Admin admin);

    @Delete("delete from admin where id = #{id}")
    int deleteByPrimaryKey(Integer id);

    @Update("update admin set password=#{password},updateTime=#{updateTime} where id=#{id}")
    int updatePassword(Admin admin);
}
