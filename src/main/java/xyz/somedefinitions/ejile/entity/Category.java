package xyz.somedefinitions.ejile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    private Integer id;
    private String name;
    private Integer businessId;
    private String imageUrl;
    private LocalDate createTime;
    private LocalDate updateTime;
    private Business business;
    private List<Commodity> commodities;
}
