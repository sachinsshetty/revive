package slabs.tech.avti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Server {


	public static void main(String[] args) {
		
		SpringApplication.run(Server.class, args);
		
		System.out.println("Simulator for Autonomous Vehicle Tech Infrasture (AVTI)");
		
	}

}
