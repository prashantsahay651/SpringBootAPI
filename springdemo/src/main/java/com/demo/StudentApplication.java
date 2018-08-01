package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.demo.controller.StudentController;

@SpringBootApplication
@EnableJpaAuditing
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	
}
