package com.devsuperior.hrpayroll.config;



//--(IMPORTS)--//

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;


//--(END)--//


@Configuration
public class AppConfig {

	//Criando componete apartir de 1 chamada de método
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
}
