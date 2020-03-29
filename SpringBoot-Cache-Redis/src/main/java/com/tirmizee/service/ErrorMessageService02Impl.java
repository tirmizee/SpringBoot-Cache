package com.tirmizee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tirmizee.jpa.enties.ErrorMessage;
import com.tirmizee.jpa.repositories.ErrorMessageRepository;

@Service
public class ErrorMessageService02Impl implements ErrorMessageService02 {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ErrorMessageService02Impl.class);
	
	@Autowired
	private ErrorMessageRepository errorMessageRepository;
	
	@Override
	public ErrorMessage getByErrorMessage02(ErrorMessage message) {
		LOGGER.info("sync database : {}", message.toString());
		return errorMessageRepository.findOne(Example.of(message)).orElse(null);
	}
	
	@Override
	@Cacheable(value = "errormessage02", keyGenerator = "customKeyGenerator" , condition="#message.id < 30")
	public ErrorMessage getCacheByErrorMessage02(ErrorMessage message) {
		return getByErrorMessage02(message);
	}
	
	@Override
	@CacheEvict(value = "errormessage02", keyGenerator = "customKeyGenerator")  
	public void deleteByCode02(ErrorMessage message) {
		ErrorMessage delete = new ErrorMessage();
		delete.setCode(message.getCode());
		delete = errorMessageRepository.findOne(Example.of(message)).orElse(null);
		if (delete != null) {
			errorMessageRepository.delete(delete);
		}
	}

	@Override
	public ErrorMessage updateErrorMessage(ErrorMessage message, String name) {
		return null;
	}

}
