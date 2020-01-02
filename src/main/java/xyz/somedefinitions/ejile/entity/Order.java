package xyz.somedefinitions.ejile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Length(max = 32,message = "Length is out of range!")
    private String number;
    private Integer userId;
    private Integer businessId;
    private Integer amount;
    private Integer deliveryId;
    private Integer deliveryFee;
    private Integer status;
    private LocalDate createTime;
    private LocalDate updateTime;
    private User user;
    private Business business;
    private Delivery delivery;
    private List<OrderDetail> orderDetails;
}
