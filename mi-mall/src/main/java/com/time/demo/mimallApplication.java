package com.time.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
public class mimallApplication {

	public static void main(String[] args) {
		SpringApplication.run(mimallApplication.class, args);
	}

}
