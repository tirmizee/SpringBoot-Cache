package com.tirmizee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tirmizee.jpa.enties.ErrorMessage;
import com.tirmizee.jpa.repositories.ErrorMessageRepository;

@Service
public class ErrorMessageService01Impl implements ErrorMessageService01 {

	public static final Logger LOGGER = LoggerFactory.getLogger(ErrorMessageService01Impl.class);
	
	@Autowired
	private ErrorMessageRepository errorMessageRepository;
		
	@Override
	public ErrorMessage getByCode(String code) {
		LOGGER.info("sync database : {}", code);
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setCode(code);
		return errorMessageRepository.findOne(Example.of(errorMessage)).orElse(null);
	}

	@Override
	@Cacheable(value = "errormessage01", key = "#code")
	public ErrorMessage getCacheByCode(String code) {
		return getByCode(code);
	}
	
	@Override
	@CacheEvict(value = "errormessage01", key = "#code")   
	public void deleteByCode(String code) {
		ErrorMessage message = getByCode(code);
		if (message != null) {
			errorMessageRepository.delete(message);
		}
	}
	
	@Override
	@CachePut(value = "errormessage01", key = "#code")   
	public ErrorMessage updateByCode(String code, ErrorMessage update) {
		ErrorMessage message = getByCode(code);
		message.setMessage(update.getMessage());
		message.setStatus(update.getStatus());
		return errorMessageRepository.save(message);
	}
	
}
