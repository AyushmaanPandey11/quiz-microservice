package com.ayushmaan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizProjectApplication.class, args);
	}

}
