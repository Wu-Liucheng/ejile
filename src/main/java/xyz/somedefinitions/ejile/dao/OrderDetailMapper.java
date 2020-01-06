package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.somedefinitions.ejile.entity.OrderDetail;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    @Select("select * from orderdetail where orderNumber = #{orderNumber}")
    List<OrderDetail> selectByOrderNumber(String orderNumber);

    @Insert("insert into orderdetail(commodityId,quantity,orderNumber,amount) values " +
            "(#{commodityId},#{quantity},#{orderNumber},#{amount});")
    int insert(OrderDetail orderDetail);
}
