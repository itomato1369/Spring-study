package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper의 interface를 스캔하여 bean으로 등록
// 기능마다 mapper package가 분리 Interface는 mapper 아래에서 동작
@MapperScan(basePackages = "com.yedam.app.**.mapper") 
public class Sp02Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp02Application.class, args);
	}

}
