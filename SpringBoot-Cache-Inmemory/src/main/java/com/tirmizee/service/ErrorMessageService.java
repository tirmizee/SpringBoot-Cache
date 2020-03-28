package com.tirmizee.service;

import java.util.List;

import com.tirmizee.jpa.enties.ErrorMessage;

public interface ErrorMessageService {
	
	ErrorMessage getByCode(String code);
	
	ErrorMessage getCacheByCode(String code);
	
	ErrorMessage getByErrorMessage(ErrorMessage message);
	
	ErrorMessage getCacheByErrorMessage01(ErrorMessage message);
	
	List<ErrorMessage> findByErrorMessage(ErrorMessage message);

	List<ErrorMessage> findCacheByErrorMessage02(Long id, String code, String status);
	
	void deleteByCode(String code);
	
}
