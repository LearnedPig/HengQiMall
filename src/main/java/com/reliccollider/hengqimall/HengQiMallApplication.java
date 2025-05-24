package com.reliccollider.hengqimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.reliccollider.hengqimall.mapper")
public class HengQiMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(HengQiMallApplication.class, args);
	}

}
