package xyz.somedefinitions.ejile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commodity {
    private Integer id;
    private String name;
    private String imageUrl;
    private String description;
    private Integer price;
    private String unit;
    private Integer stock;
    private Integer sales;
    private Boolean status;
    private Integer createId;
    private Integer updateId;
    private Integer categoryId;
    private LocalDate createTime;
    private LocalDate updateTime;
    private Category category;
}
