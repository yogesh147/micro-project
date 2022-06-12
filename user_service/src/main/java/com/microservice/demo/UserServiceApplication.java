package com.microservice.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserServiceApplication.class);

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Java path      --------- {}", env.getProperty("JAVA_HOME"));
		log.info("App Name 	    --------- {}", env.getProperty("spring.application.name"));
		log.info("Active profile --------- {}", env.getProperty("spring.profiles.active"));
		log.info("App running on --------- http://localhost:{}", env.getProperty("server.port"));
		System.out.println("");
		System.out.println("------------------------------------ User Service Running on 9001 ------------------------------------------------------");
		System.out.println("");
		log.debug("Debug Mode is ON for User Service");
	    log.warn("Warning");
	    if (log.isDebugEnabled())
	    {
	        log.debug("I am logging " + 1234 + ".");
	    }
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
