package com.dataart.dshmain.boottest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableEurekaClient
public class BootTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootTest1Application.class, args);
	}
}
