package com.devsuperior.hrpayroll.config;



//--(IMPORTS)--//
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
//--(END)--//


/*O padrão de Circuit Breaker :
	é uma técnica de design utilizada em sistemas distribuídos para melhorar a resiliência e a estabilidade, 
	protegendo um sistema contra falhas recorrentes em serviços externos ou componentes.
	
	Os 3 estado do CircuitBreaker:
		-CLOSED = Todas as chamadas são permitidas passar para o serviço externo.
	
		-OPEN = As chamadas para o serviço externo são bloqueadas temporariamente.
	
		-HALF-OPEN =  Nesse estado, permite que uma chamada de teste seja enviada ao serviço externo. 
					  Se essa chamada for bem-sucedida, o Circuit Breaker retorna ao estado fechado; 
					  caso contrário, volta ao estado aberto.
*/

@Configuration
public class CircuitBreakerConfigurationTest {

	/*CircuitBreakerRegistry :
	 * 
		-É uma classe para gerenciar circuit breakers em um aplicativo, 
		permitindo a criação, rastreamento e acesso fácil a instâncias desses mecanismos de resiliência.
	
	*/
	
	//Difinindo configurações do meu CircuitBreaker   //Nesse caso eu escolhir a padrão
	//CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.ofDefaults();
	
	
	
	
	
	
	
	@Bean
	public CircuitBreaker circuitBreakerBean() {
	
		//Criando uma instância personalizada de CircuitBreakerConfig
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(20)//Limite de taxa de falhas, Nesse caso 20%
				.slidingWindowSize(5)//Mantém um histórico das últimas 5 chamadas para calcular a taxa de falhas
				.build();
		
		
		/*Registrando Minha Configuração personalizada do meu CircuitBreaker
	  
	 	   -É responsável por gerenciar e fornecer acesso a instâncias de circuit breakers no seu aplicativo.
		 */
		CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
		
		
		//Criando uma Instancia da classe CircuitBreaker com a configuração personalizada registrada
		CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("test");//E nomeando-a de: "myCircuitBreaker"
		return circuitBreaker;
	
	}
	
}
