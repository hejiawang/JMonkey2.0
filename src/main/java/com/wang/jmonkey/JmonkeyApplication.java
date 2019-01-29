package com.wang.jmonkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={
        org.activiti.spring.boot.SecurityAutoConfiguration.class
})
@ComponentScan(basePackages = {"com.wang"})
public class JmonkeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmonkeyApplication.class, args);
    }
}
