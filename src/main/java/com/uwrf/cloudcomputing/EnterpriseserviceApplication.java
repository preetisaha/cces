package com.uwrf.cloudcomputing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class EnterpriseserviceApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EnterpriseserviceApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EnterpriseserviceApplication.class, args);
	}
}
