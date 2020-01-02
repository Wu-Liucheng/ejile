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
public class Delivery {
    private Integer id;
    @Length(max = 32,message = "Length is out of range!")
    private String username;
    @Length(max = 32,message = "Length is out of range!")
    private String password;
    @Length(min=11,max = 11,message = "Length is out of range!")
    private String mobile;
    private Integer balance;
    @Length(max = 100,message = "Length is out of range!")
    private String address;
    private LocalDate createTime;
    private LocalDate updateTime;
}
