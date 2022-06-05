package com.slabstech.revive.server.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@ComponentScan("com.slabstech.revive.server.springboot")
@EnableJpaRepositories("com.slabstech.revive.server.springboot.persistence.repo")
@EntityScan("com.slabstech.revive.server.springboot.persistence.model")
public class Application {

	public static void main(String[] args) {

		System.out.println("Template Library for RESTFul Web Apps with Micro-services");

		SpringApplication.run(Application.class, args);

	}

}
