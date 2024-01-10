package com.learning.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InvoiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceDemoApplication.class, args);
	}

}
