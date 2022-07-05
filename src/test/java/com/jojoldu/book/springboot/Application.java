package com.jojoldu.book.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

    public static void main(String[] args){
        run(com.jojoldu.book.springboot.Application.class, args);
    }
}
