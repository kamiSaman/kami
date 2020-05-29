package com.kami.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:spring/spring-boot.properties")
@ComponentScan({ "com.kami.demo", "com.kami.web" })
@MapperScan({"com.kami.web.mapper"})
public class AppBoot {

	public static void main(String[] args) {
		SpringApplication.run(AppBoot.class, args);
	}

}
