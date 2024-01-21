package com.devsuperior.hrpayroll.feignclients;



//--(IMPORTS)--//

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.devsuperior.hrpayroll.entities.Worker;

//--(END)--//


@Component //Para indicar que é um componente gerenciado pelo spring ,E pode ser injetado em outras classes
@FeignClient(name = "hr-worker"  ,path = "/workers")
public interface WorkerFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
	
}
