package xyz.somedefinitions.ejile.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin implements Serializable,Cloneable{
    /** ID */
    private Integer id ;
    /** 账户名 */
    private String username ;
    /** 密码 */
    private String password ;
    /** 权限;0代表系统管理员，1代表商家管理员 */
    private Integer authority ;
    /** 所属商家ID */
    private Integer businessId ;
    /** 创建日期 */
    private LocalDate createTime ;
    /** 修改日期 */
    private LocalDate updateTime ;

}