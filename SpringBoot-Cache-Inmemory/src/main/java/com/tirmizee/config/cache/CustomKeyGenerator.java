package com.tirmizee.config.cache;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import com.tirmizee.service.ErrorMessageServiceImpl;

public class CustomKeyGenerator implements KeyGenerator {

	public static final Logger LOGGER = LoggerFactory.getLogger(ErrorMessageServiceImpl.class);
	
	@Override
	public Object generate(Object target, Method method, Object... params) {
		String key = new StringBuilder()
			.append(target.getClass().getSimpleName()).append("_")
			.append(method.getName()).append("_")
			.append(StringUtils.arrayToDelimitedString(params, "_"))
			.toString();
		LOGGER.info(key);
		return key;
	}

}
