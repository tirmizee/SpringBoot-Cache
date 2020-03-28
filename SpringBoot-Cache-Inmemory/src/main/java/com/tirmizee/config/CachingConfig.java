package com.tirmizee.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tirmizee.config.cache.CustomKeyGenerator;

@EnableCaching
@Configuration
public class CachingConfig extends CachingConfigurerSupport {
	
	 @Bean(name = "customKeyGenerator")
	 public KeyGenerator keyGenerator() {
		 return new CustomKeyGenerator();
	 }

}
