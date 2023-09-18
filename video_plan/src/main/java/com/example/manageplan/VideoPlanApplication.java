package com.example.manageplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.manageplan.model")
public class VideoPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoPlanApplication.class, args);
	}

}
