package xyz.somedefinitions.ejile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commodity {
    private Integer id;
    @Length(max = 32,message = "Length is out of range!")
    private String name;
    @Length(max = 256,message = "Length is out of range!")
    private String imageUrl;
    @Length(max = 1024,message = "Length is out of range!")
    private String description;
    private Integer price;
    @Length(max = 10,message = "Length is out of range!")
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
