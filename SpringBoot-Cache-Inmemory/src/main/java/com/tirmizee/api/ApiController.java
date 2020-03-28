package com.tirmizee.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.api.data.ErrorDTO;
import com.tirmizee.jpa.enties.ErrorMessage;
import com.tirmizee.service.ErrorMessageService;

@RestController
public class ApiController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private ErrorMessageService errorMessageService;
	
	@GetMapping(path = "/01/message/{code}")
	public String getErrorMessage01(@PathVariable String code) {
		LOGGER.info("search by code : {}", code);
		return String.valueOf(errorMessageService.getCacheByCode(code));
	}
	
	@GetMapping(path = "/02/message")
	public String getErrorMessage02(ErrorDTO error) {
		LOGGER.info("search by error : {}", error.toString());
		ErrorMessage message = new ErrorMessage();
		message.setId(error.getId());
		message.setCode(error.getCode());
		message.setMessage(error.getMessage());
		return errorMessageService.getCacheByErrorMessage01(message).toString();
	}
	
	@GetMapping(path = "/03/message")
	public String getErrorMessage03(ErrorDTO error) {
		LOGGER.info("search by error : {}", error.toString());
		return errorMessageService.findCacheByErrorMessage02(error.getId(), error.getCode(), error.getStatus()).toString();
	}
	
	@GetMapping(path = "/delete/{code}")
	public String deleteErrorMessage(@PathVariable String code) {
		LOGGER.info("delete by error : {}", code);
		errorMessageService.deleteByCode(code);
		return "Success";
	}
	
}
