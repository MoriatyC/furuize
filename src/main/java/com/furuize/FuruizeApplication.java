package com.furuize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.furuize.service.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FuruizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuruizeApplication.class, args);
	}
}
