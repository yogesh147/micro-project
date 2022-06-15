package com.eserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EurekaServerApplication.class);

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Java path      --------- {}", env.getProperty("JAVA_HOME"));
		log.info("App Name 	    -------- {}", env.getProperty("spring.application.name"));
		log.info("Active profile --------- {}", env.getProperty("spring.profiles.active"));
		log.info("App running on --------- http://localhost:{}", env.getProperty("server.port"));
		System.out.println("");
		System.out.println(
				"------------------------------------ Eureka Server Running on "+ env.getProperty("server.port") +"------------------------------------------------------");
		System.out.println("");
		log.debug("Debug Mode is ON for Eureka Server");
	}
}
