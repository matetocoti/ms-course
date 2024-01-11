package com.devsuperior.hrworker.entities;



//--(IMPORTS)--//


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




//--(END)--//

@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	//--(ATRIBUTOS)--//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Double dailyIncome;
	
	//--(END)--//
	
	
	
	//--(CONSTRUTORES)--//
	
	public Worker() {
		
	}

	public Worker(Long id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
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

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
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
		Worker other = (Worker) obj;
		return Objects.equals(id, other.id);
	}
	
	//--(END)--//
}
