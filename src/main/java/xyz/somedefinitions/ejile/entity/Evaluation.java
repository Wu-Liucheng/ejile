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
public class Evaluation {
    @Length(max = 32,message = "Length is out of range!")
    private String number;
    private Integer stars;
    @Length(max = 1024,message = "Length is out of range!")
    private String content;
    private LocalDate createTime;
    private Order order;
}
