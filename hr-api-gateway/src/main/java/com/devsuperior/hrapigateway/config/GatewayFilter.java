//package com.devsuperior.hrapigateway.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//
//
//
////Essa classe nos permite definir lógica personalizada para processar as solicitações que passam pelo Spring Cloud Gateway. 
// 
////@Component
//public class GatewayFilter implements org.springframework.cloud.gateway.filter.GatewayFilter {
//
//	@Override				//(ServerWebExchange -> representa a troca de informações entre o cliente e o servidor ,chain -> representa a cadeia de filtros que serão executados durante o processamento da solicitação)
//	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//		
//		 
//		//Pegando minha requisição atual
//		ServerHttpRequest myCurrentServerHttpRequest = exchange.getRequest();
//		
//		
//		
//		
//		 /* Sobre o retorno 
//		 * 	o método filter deve retornar um objeto Mono<Void>. O Mono<Void> representa um resultado assíncrono que não produz um valor.
//		 *
//		 * 		O Mono é um contêiner que pode conter zero ou um único valor, e esse valor pode estar disponível imediatamente ou em algum momento futuro.
//		 *		O Mono<Void> é um tipo especial de Mono que representa um resultado futuro que não produz um valor. 
//		 * 		Em outras palavras, é usado quando a operação não retorna nenhum valor, mas ainda pode ser concluída com sucesso ou falha.  
//		*/
//		
//		return null;
//	}
//
//}
