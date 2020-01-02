package xyz.somedefinitions.ejile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class EjileApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjileApplication.class, args);
    }

}
