package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.*;
import xyz.somedefinitions.ejile.entity.Order;

@Mapper
public interface OrderMapper {
    @Select("select * from order where number = #{number};")
    Order selectByPrimaryKey(String number);

    @Insert("insert into order(number,userId,businessId,amount,deliveryFee,status,createTime,updateTime) values " +
            "(#{number},#{userId},#{businessId},#{amount},200,0,#{createTime},#{updateTime});")
    int insert(Order order);

    @Update("update order set status = -1 where number=#{number};")
    int delete(String number);

    @Update("update order set status = 1 where number=#{number}")
    int updateOrderStatus1(String number);

    @Update("update order set status = 2 , deliveryId=#{deliveryId} where number = #{number}")
    int updateOrderStatus2(Order order);

    @Update("update order set status = 3 where number = #{number}")
    int updateOrderStatus3(String number);
}
