package com.devsuperior.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.devsuperior.hruser.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT ID, NAME, EMAIL, PASSWORD FROM TB_USER WHERE UPPER(EMAIL) = UPPER(:email) " ,nativeQuery = true)
	public User findByEmailCustom(@Param(value = "email") String email);
	
	
	User findByEmail(String email);
	
}
