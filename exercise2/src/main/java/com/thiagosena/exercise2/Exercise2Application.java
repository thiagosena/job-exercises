package com.thiagosena.exercise2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class Exercise2Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercise2Application.class, args);
	}

}
