package com.luowei.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.luowei")
public class OSSApplication {
    public static void main(String[] args) {
        SpringApplication.run(OSSApplication.class);
    }
}
