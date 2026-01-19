package com.practice.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* Mybatis 에서 읽어야 하는 Interface 분리
mapper의 interface를 스캔하여 bean으로 등록
기능마다 mapper package가 분리 Interface는 mapper 아래에서 동작
 * */
@SpringBootApplication
@MapperScan(basePackages = "com.practice.java.**.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*
	 * 맨 처음 main Method를 찾는다 
	 * @SpringBootApplication
	 * @MapperScan을 보고 이건  Spring framework구나 하고 인식
	 *  .properties   pom.xml
	 *  com.practice.java 아래에 모든 패키지 다 읽어들임
	 */

}
