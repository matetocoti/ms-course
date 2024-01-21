package com.devsuperior.hrpayroll.entities;



//--(IMPORTS)--//


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//--(END)--//


//--BIBLIOTECA PROJETO LOMBOK

/*
 As anotações que você forneceu são provenientes do projeto Lombok, que é uma 
 biblioteca para Java que ajuda a reduzir a verbosidade do código, especialmente 
 em classes que possuem muitos getters, setters, construtores e métodos de 
 toString, equals e hashCode.
*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Worker implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	//--(ATRIBUTOS)--//


	private Long id;
	private String name;
	private Double dailyIncome;
	
	//--(END)--//
	
}
