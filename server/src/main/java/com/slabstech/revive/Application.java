package com.slabstech.revive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@ComponentScan("slabs.tech.avti")
@EnableJpaRepositories("slabs.tech.avti.persistance.repo")
@EntityScan("slabs.tech.avti.persistance.model")
public class Application {

	public static void main(String[] args) {

		System.out.println("Simulator for Autonomous Vehicle Tech Infrasture (AVTI)");

		SpringApplication.run(Application.class, args);

	}

}
