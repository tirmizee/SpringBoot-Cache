package com.tirmizee.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.api.data.ErrorDTO;
import com.tirmizee.jpa.enties.ErrorMessage;
import com.tirmizee.service.ErrorMessageService02;

@RestController
public class ApiController02 {

	public static final Logger LOGGER = LoggerFactory.getLogger(ApiController02.class);
	
	@Autowired
	private ErrorMessageService02 errorMessageService02;

	/*
	 * http://localhost:9000/02/message?code=ER000007
	 */
	@GetMapping(path = "/02/message")
	public String getErrorMessage02(ErrorDTO dto) {
		LOGGER.info("search by error : {}", dto);
		ErrorMessage message = new ErrorMessage();
		message.setId(dto.getId());
		message.setCode(dto.getCode());
		message.setStatus(dto.getStatus());
		message.setMessage(dto.getMessage());
		return String.valueOf(errorMessageService02.getCacheByErrorMessage02(message));
	}
	
	/*
	 * http://localhost:9000/02/delete?code=ER000007
	 */
	@GetMapping(path = "/02/delete")
	public String deleteErrorMessage(ErrorDTO dto) {
		LOGGER.info("delete by error : {}", dto);
		ErrorMessage message = new ErrorMessage();
		message.setCode(dto.getCode());
		errorMessageService02.deleteByCode02(message);
		return "Success";
	}

	/*
	 * http://localhost:9000/02/update?code=ER000007
	 */
	@GetMapping(path = "/02/update")
	public String updateErrorMessage(ErrorDTO dto) {
		LOGGER.info("update by error : {}", dto);
		ErrorMessage message = new ErrorMessage();
		message.setCode(dto.getCode());
		return String.valueOf(errorMessageService02.updateErrorMessage(message, dto.getMessage()));
	}

}
