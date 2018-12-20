package site.taru.magic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "site.taru.magic.mapper")
@EnableScheduling
public class WebmagicApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebmagicApplication.class, args);
    }
}
