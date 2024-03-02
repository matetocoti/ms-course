package com.devsuperior.hruser.entities;


//--(IMPORTS)--//

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//--(END)--//



@Entity
@Table(name = "tb_role")
public class Role implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//--(ATRIBUTOS)--//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String roleName;
	
	//--(END)--//
	

	
	
	//--(CONSTRUTORES)--//
	
	public Role(){
	}
	
	public Role(Long id ,String roleName){
		this.id = id;
		this.roleName = roleName;
	}
	
	//--(END)--//

	
	
	//--(GETTERS AND SETTERS)--//
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	//--(END)--//
	
	
	
	//--(HASHCODE AND EQUALS)--//
	
	@Override
	public int hashCode() {
		return Objects.hash(roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(roleName, other.roleName);
	}
	
	//--(END)--//
}
