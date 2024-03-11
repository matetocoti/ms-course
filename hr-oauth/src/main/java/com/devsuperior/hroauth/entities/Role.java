package com.devsuperior.hroauth.entities;


//--(IMPORTS)--//

import java.io.Serializable;
import java.util.Objects;


//--(END)--//




public class Role implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//--(ATRIBUTOS)--//
	
	
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
