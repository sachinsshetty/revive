package slabs.tech.avti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		System.out.println("Simulator for Autonomous Vehicle Tech Infrasture (AVTI)");

		SpringApplication.run(Application.class, args);

	}

}
