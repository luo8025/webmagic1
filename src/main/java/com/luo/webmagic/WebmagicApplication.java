package com.luo.webmagic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.luo.webmagic.mapper")
@EnableScheduling
public class WebmagicApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebmagicApplication.class, args);
    }
}
