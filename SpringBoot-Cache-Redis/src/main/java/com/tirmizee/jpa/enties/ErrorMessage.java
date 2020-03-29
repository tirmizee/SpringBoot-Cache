package com.tirmizee.jpa.enties;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "ERROR_MESSAGE")
public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "STATUS")
	private String status;
	
}
