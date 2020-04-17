package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringFormsJpaaPiApi2Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
	return application.sources(SpringFormsJpaaPiApi2Application.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringFormsJpaaPiApi2Application.class, args);
	}

}
