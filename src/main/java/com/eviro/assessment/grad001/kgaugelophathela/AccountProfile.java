package com.eviro.assessment.grad001.kgaugelophathela;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountProfile {
	
	@Id
	private String name;
	private String surname;
	private String httpImageLink;
	
	public AccountProfile(){
		
	}
	
	public AccountProfile(String name, String surname, String httpImageLink ) {
		this.name=name;
		this.surname=surname;
		this.httpImageLink=httpImageLink;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getHttpImageLink() {
		return httpImageLink;
	}

	public void setHttpImageLink(String httpImageLink) {
		this.httpImageLink = httpImageLink;
	}

}
