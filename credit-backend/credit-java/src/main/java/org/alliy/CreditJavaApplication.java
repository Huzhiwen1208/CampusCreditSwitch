package org.alliy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("org.alliy.mapper")
public class CreditJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditJavaApplication.class, args);

    }

}
