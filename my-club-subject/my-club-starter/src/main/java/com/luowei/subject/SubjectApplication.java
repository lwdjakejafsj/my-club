package com.luowei.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: luowei
 * @Description: 刷题服务启动类
 * @DateTime:
 */
@SpringBootApplication
@ComponentScan("com.luowei")
@MapperScan("com.luowei.**.mapper")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
