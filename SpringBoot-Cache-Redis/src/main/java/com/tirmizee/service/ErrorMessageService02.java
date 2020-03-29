package com.tirmizee.service;

import com.tirmizee.jpa.enties.ErrorMessage;

public interface ErrorMessageService02 {
	
	ErrorMessage getByErrorMessage02(ErrorMessage message);
	
	ErrorMessage getCacheByErrorMessage02(ErrorMessage message);
	
	void deleteByCode02(ErrorMessage message);
	
	ErrorMessage updateErrorMessage(ErrorMessage message, String name);
	
}
