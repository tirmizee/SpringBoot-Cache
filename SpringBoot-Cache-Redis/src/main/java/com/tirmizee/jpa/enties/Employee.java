package com.tirmizee.jpa.enties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "CODE", unique = true, nullable = false)
	private String code;
	
	@Column(name = "FIRST_NAME", unique = true, nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", unique = true, nullable = false)
	private String lastName;
	
	@Column(name = "CITIZEN_ID", unique = true, nullable = false)
	private String citizenId;
	
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	@Column(name = "TEL", unique = true, nullable = false)
	private String tel;
	
}
