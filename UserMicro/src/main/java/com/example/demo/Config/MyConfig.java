package com.example.demo.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

//	now here we can create as many as bean as we want in the project
	@Bean
	@LoadBalanced   //it is used after we made changes to port name hotel-microservice from localhost:8081 so after immedicately changing and running nad then in postman on get it shows error so we have to use load balanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
//	now u can remove the rest template bean from the main application
//	now we can use rest Template to call the rating service in user service for getting the rating of particular user
}
