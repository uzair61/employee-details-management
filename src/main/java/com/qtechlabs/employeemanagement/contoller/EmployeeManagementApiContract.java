package com.qtechlabs.employeemanagement.contoller;

import org.springframework.http.ResponseEntity;

import com.qtechlabs.employeemanagement.dto.EmployeeDTO;

public interface EmployeeManagementApiContract {
	
	public ResponseEntity<String> createEmployee( EmployeeDTO employeeDto);
	
	public ResponseEntity<EmployeeDTO> getEmployee( Long employeeId);
	
	public ResponseEntity<String> updateEmployee( Long employeeId , EmployeeDTO employeeDto);
	
	public ResponseEntity<String> deleteEmployee( Long employeeId);

}
