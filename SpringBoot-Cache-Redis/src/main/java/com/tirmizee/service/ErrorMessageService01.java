package com.tirmizee.service;

import com.tirmizee.jpa.enties.ErrorMessage;

public interface ErrorMessageService01 {
	
	ErrorMessage getByCode(String code);
	
	ErrorMessage getCacheByCode(String code);
	
	ErrorMessage updateByCode(String code, ErrorMessage update);
	
	void deleteByCode(String code);
	
}
