package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.somedefinitions.ejile.entity.Commodity;

import java.util.List;

@Mapper
public interface CommodityMapper {
    @Select("select * from commodity where id = #{id} and status = 1")
    Commodity selectByPrimaryKey(Integer id);

    @Select("select * from commodity where categoryId = #{id} and status = 1")
    List<Commodity> selectByCategoryId(Integer id);

    @Insert("insert into commodity(name,imageUrl,description,price,unit,stock,sales,status,createId,updateId,categoryId," +
            "createTime,updateTime) values ( #{name},#{imageUrl},#{description},#{price},#{unit},#{stock}" +
            ",#{sales},#{status},#{createId},#{updateId},#{categoryId},#{createTime},#{updateTime});")
    int insert(Commodity commodity);

    @Update("update commodity set status = 0 where id = #{id};")
    int delete(Integer id);

    @Update("update commodity set name = #{name},imageUrl = #{imageUrl},description = #{description}," +
            "price = #{price},unit = #{unit},updateTime = #{updateTime} where id = #{id};")
    int update(Commodity commodity);

    @Update("update commodity set stock = #{stock} where id = #{id}")
    int updateStock(Commodity commodity);

    @Update("update commodity set sales = #{sales} where id = #{id}")
    int updateSales(Commodity commodity);
}
