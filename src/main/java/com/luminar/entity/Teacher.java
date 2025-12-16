package com.luminar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // strategy is mentioned for auto increment
	private Long id; 
	/*
	 * jpa rule mentions to set wrapper class Long for primary key.Long since it can have 
	 * the max values possible
	 */
	
	@Column(name="name") //column name when jpa hibernate creates table
	private String name;
	
	@Column(name="subject")
	private String subject;
	
	public Teacher() {}
	
	/*
	 * hibernate requires default constructor.When hibernate reads data from database
	 * it creates an emoty object and uses setters to set fields with value (reflector).
	 * If it is a parameterized constructor ,then jpa will have to guess order of parameters
	 */

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}

/*
 * @Entity marks a class as a JPA-managed persistent object, allowing Hibernate
 *  to map it to a database table and manage its lifecycle.
 */
