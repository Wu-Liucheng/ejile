package xyz.somedefinitions.ejile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
    private Long id;
    private Integer commodityId;
    private Integer quantity;
    private Integer amount;
    @Length(max = 32,message = "Length is out of range!")
    private String orderNumber;
    private Order order;
}
