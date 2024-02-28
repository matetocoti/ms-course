package com.devsuperior.hrapigateway.config;



//--(IMPORTS)--//


import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//--(END)--//


@Configuration
public class GatewayConfig {

	
	@Bean
    RestClient.Builder restClientBuilder() {
        return RestClient.builder(new RestTemplate());
    }
	
	
	// /hr-worker/(?<segment>.*): Esta parte define a expressão regular que corresponde a qualquer URL que comece com /hr-worker/ e captura qualquer coisa que venha depois dessa parte (representada por (?<segment>.*)). 
	// O ?<segment> cria um grupo chamado segment, que armazena o restante da URL.
	// /$\\{segment}: Aqui definimos como a URL será reescrita. O ${segment} é uma variável que contém o valor capturado pelo grupo segment na expressão regular.
	// O $ antes da chave { é um escape necessário para que a variável seja interpretada corretamente. Então, estamos dizendo que queremos substituir a parte correspondente da URL pela variável segment.
	
	
	
	
	@Bean
	RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				
				.route("worker-service", r -> r.path("/hr-worker/**")
						.filters(f -> f.rewritePath("/hr-worker/(?<segment>.*)", "/$\\{segment}"))
						.uri("lb://hr-worker"))
				.route("hr-payroll", r -> r.path("/hr-payroll/**")	
						.filters(f -> f.rewritePath("/hr-payroll/(?<segment>.*)", "/$\\{segment}"))
						.uri("lb://hr-payroll"))
				.build();	
	}
	
	
	
}
