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
public class Category {
    private Integer id;
    @Length(max = 32,message = "Length is out of range!")
    private String name;
    private Integer businessId;
    @Length(max = 256,message = "Length is out of range!")
    private String imageUrl;
    private LocalDate createTime;
    private LocalDate updateTime;
    private Business business;
    private List<Commodity> commodities;
}
