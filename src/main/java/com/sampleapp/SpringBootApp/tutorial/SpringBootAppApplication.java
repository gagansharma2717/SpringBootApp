package com.sampleapp.SpringBootApp.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

}

// Run Application with different profiles
// Run mvn clean install
// cd target and type dir
// type java -jar SpringBootApp-1.0.0.jar --spring.profiles.active=prod

