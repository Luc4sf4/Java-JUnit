package com.br.JUnitStudy.JUnitTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.br.JUnitStudy")
@SpringBootApplication
public class JUnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JUnitTestApplication.class, args);
	}

}
