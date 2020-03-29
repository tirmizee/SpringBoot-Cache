package com.tirmizee.config.cache;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;

import com.tirmizee.service.ErrorMessageService01Impl;

public class CustomKeyGenerator implements KeyGenerator {

	public static final Logger LOGGER = LoggerFactory.getLogger(ErrorMessageService01Impl.class);
	
//	@Override 
//	public Object generate(Object target, Method method, Object... params) {
//		String key = new StringBuilder()
//			.append(target.getClass().getSimpleName()).append("_")
//			.append(method.getName()).append("_")
//			.append(StringUtils.arrayToDelimitedString(params, "_"))
//			.toString();
//		LOGGER.info(key);
//		return key;
//	}
	
	@Override
	public Object generate(Object target, Method method, Object...params) {
		Object object = generateKey(params);
		System.out.println(String.valueOf(object));
		return object;
	}
	
	public static Object generateKey(Object...params) {
		
		if (params.length == 0) {
			return CustomCacheKey.EMPTY;
		}
		
		if (params.length == 1) {
		   Object param = params[0];
		   if (param != null && !param.getClass().isArray()) {
			   return param;
		   }
		}

		return new CustomCacheKey(params);
	}

}
