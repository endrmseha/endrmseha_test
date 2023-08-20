package com.sparta.endrmseha_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EndrmsehaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndrmsehaTestApplication.class, args);
    }

}
