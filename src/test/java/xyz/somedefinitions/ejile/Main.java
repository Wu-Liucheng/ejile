package xyz.somedefinitions.ejile;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    @Test
    public void test1(){
        System.out.println(LocalDate.now());
    }

    @Test
    public void test2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Timestamp.valueOf(LocalDateTime.now()).getTime());
        }
    }
}
