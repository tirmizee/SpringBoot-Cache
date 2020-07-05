package com.tirmizee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tirmizee.jpa.enties.Employee;
import com.tirmizee.jpa.repositories.EmployeeRepository;

@Service
public class CacheServiceImpl implements CacheService {

	public static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Cacheable(value = "employee", key = "#key")
	public Employee getEmployee(String key, Employee search) {
		List<Employee> employees = employeeRepository.findAll(Example.of(search));
		return employees.isEmpty() ? null : employees.get(0);
	}

}
