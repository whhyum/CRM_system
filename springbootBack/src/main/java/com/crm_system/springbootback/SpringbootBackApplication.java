package com.crm_system.springbootback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.crm_system.springbootback.mapper")
public class SpringbootBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackApplication.class, args);
    }

}
