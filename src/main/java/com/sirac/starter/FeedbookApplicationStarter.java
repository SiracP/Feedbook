package com.sirac.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.sirac"})
@EnableJpaRepositories(basePackages = {"com.sirac"})
@EntityScan(basePackages = {"com.sirac"})
@SpringBootApplication
public class FeedbookApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(FeedbookApplicationStarter.class, args);
	}

}
