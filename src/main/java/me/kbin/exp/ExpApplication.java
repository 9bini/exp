package me.kbin.exp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "me.kbin.exp.mybatis.*")
@EnableCaching
public class ExpApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExpApplication.class, args);
  }

}
