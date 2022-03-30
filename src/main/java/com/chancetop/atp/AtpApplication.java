package com.chancetop.atp;

import com.chancetop.atp.repositories.impl.BaseJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass= BaseJpaRepositoryImpl.class)
public class AtpApplication {
	public static void main(String[] args) {
		SpringApplication.run(AtpApplication.class, args);
	}
}
