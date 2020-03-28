package com.tirmizee.service;

import java.util.List;

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
public class ErrorMessageServiceImpl implements ErrorMessageService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ErrorMessageServiceImpl.class);
	
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
	public ErrorMessage getByErrorMessage(ErrorMessage message) {
		LOGGER.info("sync database : {}", message.toString());
		return errorMessageRepository.findOne(Example.of(message)).orElse(null);
	}

	@Override
	@Cacheable(value = "errormessage02", condition="#message.id < 30")
	public ErrorMessage getCacheByErrorMessage01(ErrorMessage message) {
		return getByErrorMessage(message);
	}

	@Override
	public List<ErrorMessage> findByErrorMessage(ErrorMessage message) {
		LOGGER.info("sync database : {}", message.toString());
		return errorMessageRepository.findAll(Example.of(message));
	}

	@Override
	@Cacheable(value = "errormessage02", keyGenerator = "customKeyGenerator")
	public List<ErrorMessage> findCacheByErrorMessage02(Long id, String code, String status) {
		ErrorMessage message = new ErrorMessage();
		message.setId(id);
		message.setCode(code);
		message.setStatus(status);
		return findByErrorMessage(message);
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
