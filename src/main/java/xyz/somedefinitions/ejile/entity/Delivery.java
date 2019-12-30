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
public class Delivery {
    private Integer id;
    private String username;
    private String password;
    private String mobile;
    private Integer balance;
    private String address;
    private LocalDate createTime;
    private LocalDate updateTime;
}
