package xyz.somedefinitions.ejile.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Business {
    private Integer id;
    @Length(max = 32,message = "Length is out of range!")
    private String number;
    @Length(max = 32,message = "Length is out of range!")
    private String name;
    @Length(max = 1024,message = "Length is out of range!")
    private String description;
    @Length(max = 256,message = "Length is out of range!")
    private String imageUrl;
    @Length(max = 100,message = "Length is out of range!")
    private String address;
    private Integer balance;
    @Length(min=11,max = 11,message = "Length is out of range!")
    private String mobile;
    private LocalDate createTime;
    private LocalDate updateTime;
    private List<Category> categories;
    private List<Admin> admins;
}
