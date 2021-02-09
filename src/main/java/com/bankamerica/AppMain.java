package com.bankamerica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.bankamerica.model")
@SpringBootApplication(scanBasePackages = "com.bankamerica")
@EnableJpaRepositories("com.bankamerica.repository")
@ComponentScan
public class AppMain {


    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

}