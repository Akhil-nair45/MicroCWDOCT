package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroApplication.class, args);
	}
	
//	we r doing it or creating a bean so that we can autowired it in service class for getting the rating of particular user
//	Also if u dont want to write it in main package we can create a config package and write this code there also so that it is easy to maintain and manevour
//	@Bean
//	public RestTemplate restTemplate()
//	{
//		return new RestTemplate();
//	}
//	this line is been commented and been written in the config file were all the beans are controlled

}
