package com.devsuperior.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	//Pegando o valor do username nas variaveis de ambiente properties
	@Value("${spring.cloud.config.server.git.username}")
	private String username; 
	//Pegando o valor do password nos properties
	@Value("${spring.cloud.config.server.git.password}")
	private String password;
	
	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.printf("USERNAME = %s%nPASSWORD = %s%n" ,username ,password);
	}

}
