package com.bsc.spring.boot.simple.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bsc")
@MapperScan("com.bsc")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
