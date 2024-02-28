package com.devsuperior.hrworker.resources;



//--(IMPORTS)--//

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

//--(END)--//



/*
  Quando você usa @RefreshScope em um bean Spring, ele se torna "atualizável", 
  o que significa que o Spring Boot monitora as alterações nas propriedades de configuração. 
  Quando essas propriedades são alteradas e o endpoint /actuator/refresh é chamado, 
  o Spring atualiza os beans anotados com @RefreshScope com os novos valores das propriedades de configuração, 
  sem precisar reiniciar o aplicativo. 
   
 */


//Colocar em toda classe que tem acesso as configurações

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	//O código cria um logger chamado logger para a classe WorkerResource, 
	//permitindo que mensagens de log sejam registradas durante a execução do programa. 
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	//Guarda valor da configuração de teste
	@Value("${test.config}")
	private String testConfig;
		
	@Autowired
	private WorkerRepository workerRepository;
	

	
	
	
	
	
	
	
	//Método que pega as configurações do servidor de configurações
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok().body(workerRepository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(workerRepository.findById(id).get());
	}
	
	

}
