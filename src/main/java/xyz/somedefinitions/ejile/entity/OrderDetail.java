package xyz.somedefinitions.ejile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {
    private Long id;
    private Integer commodityId;
    private Integer quantity;
    private Integer amount;
    private String orderNumber;
    private Order order;
}
