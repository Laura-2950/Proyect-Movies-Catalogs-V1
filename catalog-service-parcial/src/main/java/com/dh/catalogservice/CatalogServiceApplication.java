package com.dh.catalogservice;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatalogServiceApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/log4j.properties");
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
