package com.qtechlabs.employeemanagement.configiration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfigration {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
