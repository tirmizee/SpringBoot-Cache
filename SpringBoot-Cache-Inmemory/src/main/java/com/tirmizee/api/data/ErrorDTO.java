package com.tirmizee.api.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorDTO {

	private Long id;
	private String code;
	private String message;
	private String status;
	
}
