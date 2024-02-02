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

	
	//AuthenticationFilter filter;
	
	@Bean
    RestClient.Builder restClientBuilder() {
        return RestClient.builder(new RestTemplate());
    }
	
	@Bean
	RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route("hr-worker", r -> r.path("/workers/**")
						.uri("lb://hr-worker"))
				.route("hr-payroll", r -> r.path("/payments/**")
						.uri("lb://hr-payroll"))
				.build();
	}
	
	
	
}
