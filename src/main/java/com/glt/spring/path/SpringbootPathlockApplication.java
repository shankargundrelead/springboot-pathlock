package com.glt.spring.path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootPathlockApplication {
@GetMapping("/message")
	public String getMessage() {
		return "Hi welcome to Shankar's app";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootPathlockApplication.class, args);
	}

}
