package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //내가 설정클래스파일이라는 의미 // and also 스프링 시작 tomcat시작 
@ComponentScan //basePackages 설정 없으면 com.example.demo; 현재패키지 디폴트
@ComponentScan(basePackages = {"upload","board.spring.mybatis"}) //패키지 늘때마다 추가해 주어야함
@ComponentScan(basePackages = "spring.mybatis")
@ComponentScan(basePackages = "websocket")
@ComponentScan(basePackages = "dbsecure")

@MapperScan(basePackages={"spring.mybatis","board.spring.mybatis"})
public class SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}

}
