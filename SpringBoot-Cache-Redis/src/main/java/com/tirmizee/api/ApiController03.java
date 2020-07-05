package com.tirmizee.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.jpa.enties.Employee;
import com.tirmizee.service.CacheService;

@RestController
@RequestMapping(value = "/employee")
public class ApiController03 {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ApiController03.class);
	
	@Autowired
	private CacheService cacheService;
	
	@GetMapping(path = "/search")
	public String searchEmployee(@RequestParam String code, @RequestParam String email, @RequestParam String tel) {
		LOGGER.info("search by employee ");
		String key = String.format("%s-%s-%s", code, email, tel);
		Employee search = new Employee();
		search.setCode(code);
		search.setEmail(email);
		search.setTel(tel);
		return String.valueOf(cacheService.getEmployee(key, search));
	}

}
