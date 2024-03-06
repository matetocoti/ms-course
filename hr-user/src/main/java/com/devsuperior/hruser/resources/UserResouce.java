package com.devsuperior.hruser.resources;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResouce {

	@Autowired
	private UserRepository repository;
	
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam(value = "email" ,defaultValue = "") String email){
		return ResponseEntity.ok().body(repository.findByEmailCustom(email));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		Optional<User> optionalUser = repository.findById(id);
		return ResponseEntity.ok().body(optionalUser.get());
	}
	
	
//	@GetMapping(value = "/search")
//	public ResponseEntity<User> findByEmail(@RequestParam(value = "email" ,defaultValue = "") String email){
//		return ResponseEntity.ok().body(repository.findByEmail(email));
//	}
	
	
	
}
