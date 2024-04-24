package com.deux.duohaeduo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DuoHaeDuoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuoHaeDuoApplication.class, args);
    }

}
