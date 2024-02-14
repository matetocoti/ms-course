package com.devsuperior.hrpayroll.resources;





//--(IMPORTS)--//


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;


//--(END)--//


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
		

	public static final String PAYMENT_SERVICE="paymentService";

	
	
	@GetMapping(value = "/{workerId}/days/{days}")
	@CircuitBreaker(name = PAYMENT_SERVICE ,fallbackMethod = "getAlternativePayment")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId ,@PathVariable Integer days){
		return ResponseEntity.ok().body(paymentService.getPayment(workerId, days));
	}
	

	//Método alternativo para quando getPayment() estiver indisponivel
	public ResponseEntity<Payment> getAlternativePayment(Long workerId ,Integer days ,Exception e){
		Payment payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok().body(payment);
	}
	

	
}
