package com.devsuperior.hruser.entities;

//--(IMPORTS)--//

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//--(END)--//



@Entity
@Table(name = "tb_user")
public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//--(ATRIBUTOS)--//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(unique = true)//Definindo que o email não pode se repetir
	private String email;
	private String password;
	//--(END)--//
	

	@ManyToMany(fetch = FetchType.EAGER) //EAGER para que os dados dos perfis sejam automaticamente carregado junto ao do usuario							
	@JoinTable(name = "tb_user_role" ,	//Tabela de associação de n x n
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
	
	
	//--(CONSTRUTORES)--//
	
	public User() {
		
	}
	
	public User(Long id ,String name ,String email ,String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	//--(END)--//


	
	
	//--(GETTERS AND SETTERS)--//
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	//--(END)--//
	
	
	
	//--(HASHCODE AND EQUALS)--//
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	//--(END)--//
	
}
