package xyz.somedefinitions.ejile.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Business {
    private Integer id;
    private String number;
    private String name;
    private String description;
    private String imageUrl;
    private String address;
    private Integer balance;
    private String mobile;
    private LocalDate createTime;
    private LocalDate updateTime;
    private List<Category> categories;
    private List<Admin> admins;
}
