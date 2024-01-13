package com.devsuperior.hrpayroll.services;



//--(IMPORTS)--//

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;

//--(END)--//


@Service
public class PaymentService {

	//Pegando minha propriedade adicional criado por mim no application.properties 
	//@Value("${hr-worker.host}")
	//private String workerHost;//E guardando em 1 variavel de tipo String
	// jeito mais dificil sem Feign
	//@Autowired
	//private RestTemplate restTemplate;
	
	//Mais facil Com Feign
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	
	
	//Método que chame no microserviço|Projeto de Worker  o Worker correspondente ao id passado como parametro
	// E instancia 1 Worker e seu pagamento
	public Payment getPayment(Long workerId ,int days) {
		
		
		/*COM REST-TEMPLATE|SEM FEIGN 
		//Criando dicionario de parametros
		//Map<String ,String> uriVariable = new HashMap<>();
		//Guardando parametros no meu Dicionario|Coleção de parametros uri
		//uriVariable.put("id", String.valueOf(workerId));
		//FAZENDO REQUISIÇÃO|BUSCANDO OBJ WORKER	// (URL DA REQUISIÇÃO    ,TIPO DO OBJ BUSCADO ,PARAMETROS DA REQUISIÇÃO) 
		//Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}"  ,Worker.class ,uriVariable);
		*/
		
		
		//Fazendo requisição com a interface feign e Requisitando um Worker do meu outro Projeto hr-worker 
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		
		return new Payment(worker.getName() ,worker.getDailyIncome() ,days);
	}
	
	
	
}
