package com.Java.loginreg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {
	// table 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;


	
	
	
	
	
	
	// constructor ///
	
	public Role() {
		super();
	}






	public Role(String name) {
		super();
		this.name = name;
	}

	
	
	
	
	
	// Getter Setter Methods here 
	

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
	
	
	
	
	
	
	
	

}
