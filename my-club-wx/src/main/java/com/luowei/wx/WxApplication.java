package com.luowei.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.luowei")
public class WxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class,args);
    }
}
