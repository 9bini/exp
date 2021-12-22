package me.kbin.exp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "me.kbin.exp.mybatis.*")
public class ExpApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExpApplication.class, args);
  }

}
