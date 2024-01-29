package com.devsuperior.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;




/*
 * OpenFeign é uma biblioteca do Spring Cloud que facilita a criação de clientes REST declarativos. 
 * Com OpenFeign, você pode definir um cliente para uma API externa simplesmente criando uma interface e anotando-a com @FeignClient. 
 * Isso permite que você faça chamadas para essa API como se estivesse invocando métodos Java locais. 
 * OpenFeign cuida de toda a comunicação HTTP por trás das cenas, tornando o processo muito mais simples e limpo.
 */


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
