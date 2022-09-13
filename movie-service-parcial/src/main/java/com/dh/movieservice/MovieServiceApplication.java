package com.dh.movieservice;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieServiceApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/log4j.properties");
		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
