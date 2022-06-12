package com.microservice.demo.user;

import org.springframework.web.client.RestTemplate;

public class CustomRestTemplate extends RestTemplate {

	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
