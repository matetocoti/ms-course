package com.devsuperior.hrpayroll.services;

//--(IMPORTS)--//

import org.springframework.stereotype.Service;
import com.devsuperior.hrpayroll.entities.Payment;

//--(END)--//


@Service
public class PaymentService {

	
	//Método que chame no microserviço|Projeto de Worker  o Worker correspondente ao id passado como parametro
	// E instancia 1 Worker
	public Payment getPayment(Long workerId ,int days) {
		return new Payment("Bob" ,200.0 ,days);
	}
	
	
	
}
