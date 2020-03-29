package com.tirmizee.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.api.data.ErrorDTO;
import com.tirmizee.jpa.enties.ErrorMessage;
import com.tirmizee.service.ErrorMessageService01;

@RestController
public class ApiController01 {

	public static final Logger LOGGER = LoggerFactory.getLogger(ApiController01.class);
	
	@Autowired
	private ErrorMessageService01 errorMessageService01;
	
	@GetMapping(path = "/01/message/{code}")
	public String getErrorMessage01(@PathVariable String code) {
		LOGGER.info("search by code : {}", code);
		return String.valueOf(errorMessageService01.getCacheByCode(code));
	}
	
	@GetMapping(path = "/01/delete/{code}")
	public String deleteErrorMessage(@PathVariable String code) {
		LOGGER.info("delete by code : {}", code);
		errorMessageService01.deleteByCode(code);
		return "Success";
	}
	
	@GetMapping(path = "/01/update/{code}")
	public String updateErrorMessage(@PathVariable String code, ErrorDTO error) {
		LOGGER.info("update by code : {}", code);
		ErrorMessage update = new ErrorMessage();
		update.setMessage(error.getMessage());
		update.setStatus(error.getStatus());
		return String.valueOf(errorMessageService01.updateByCode(code, update));
	}
	
}
