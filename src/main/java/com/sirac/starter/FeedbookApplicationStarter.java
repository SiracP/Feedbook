package com.sirac.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class FeedbookApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(FeedbookApplicationStarter.class, args);
	}

}
