package com.lucas.rastreio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RastreioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RastreioApplication.class, args);
	}

}
