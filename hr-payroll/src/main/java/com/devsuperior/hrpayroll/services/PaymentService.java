package com.devsuperior.hrpayroll.services;



//--(IMPORTS)--//

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

//--(END)--//


@Service
public class PaymentService {

	//Pegando minha propriedade adicional criado por mim no application.properties 
	@Value("${hr-worker.host}")
	private String workerHost;//E guardando em 1 variavel de tipo String
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	//Método que chame no microserviço|Projeto de Worker  o Worker correspondente ao id passado como parametro
	// E instancia 1 Worker e seu pagamento
	public Payment getPayment(Long workerId ,int days) {
		
		//Criando dicionario de parametros
		Map<String ,String> uriVariable = new HashMap<>();
		//Guardando parametros no meu Dicionario|Coleção de parametros uri
		uriVariable.put("id", String.valueOf(workerId));
		
		
		
		//FAZENDO REQUISIÇÃO|BUSCANDO OBJ WORKER
												// (URL DA REQUISIÇÃO    ,TIPO DO OBJ BUSCADO ,PARAMETROS DA REQUISIÇÃO) 
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}"  ,Worker.class ,uriVariable);
		
		
		return new Payment(worker.getName() ,worker.getDailyIncome() ,days);
	}
	
	
	
}
