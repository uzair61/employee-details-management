package com.qtechlabs.employeemanagement.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qtechlabs.employeemanagement.dto.EmployeeDTO;
import com.qtechlabs.employeemanagement.service.EmployeeManagementServiceContractImpl;

@RestController
public class EmployeeManagementApiContactImpl implements EmployeeManagementApiContract {

	@Autowired
	private EmployeeManagementServiceContractImpl service;

	@PostMapping("/api/v1/employee/")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDto) {
		service.createEmployee(employeeDto);
		return new ResponseEntity<String>("Employee Created", HttpStatus.CREATED);
	}

	@GetMapping("/api/v1/employee/{employeeId}/")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) {
		EmployeeDTO employee = service.getEmployee(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping("/api/v1/employee/{employeeId}/")
	public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDto) {
		service.updateEmployee(employeeId, employeeDto);
		return new ResponseEntity<String>("Employee Details Updated", HttpStatus.OK);

	}

	@DeleteMapping("/api/v1/employee/{employeeId}/")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
		service.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}

}
