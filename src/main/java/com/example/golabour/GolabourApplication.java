package com.example.golabour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.golabour.model")
@EnableJpaRepositories(basePackages = "com.example.golabour.dao")
@ComponentScan(basePackages = "com.example.golabour")
public class GolabourApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolabourApplication.class, args);
		System.out.println("Hello Spring");
	}

}
