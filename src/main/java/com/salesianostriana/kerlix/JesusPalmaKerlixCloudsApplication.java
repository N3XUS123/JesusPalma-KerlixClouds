
package com.salesianostriana.kerlix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JesusPalmaKerlixCloudsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JesusPalmaKerlixCloudsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insertInitialData() {
		return args -> {
		};
	}
}
