package com.smarthouse.smarthouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmartHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartHouseApplication.class, args);
	}
}
