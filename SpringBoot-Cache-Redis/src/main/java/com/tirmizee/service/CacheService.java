package com.tirmizee.service;

import com.tirmizee.jpa.enties.Employee;

public interface CacheService {
	
	Employee getEmployee(String key, Employee search);

}
