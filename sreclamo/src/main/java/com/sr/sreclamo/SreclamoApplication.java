package com.sr.sreclamo;

import com.sr.sreclamo.repo.usuariosRepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = usuariosRepo.class)
public class SreclamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SreclamoApplication.class, args);
	}

}
