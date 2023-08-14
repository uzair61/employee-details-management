package com.qtechlabs.employeemanagement.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtechlabs.employeemanagement.dto.EmployeeDTO;
import com.qtechlabs.employeemanagement.model.Employee;
import com.qtechlabs.employeemanagement.repository.EmployeeManagementRepositoryContract;

@Service
public class EmployeeManagementServiceContractImpl implements EmployeeManagementServiceContract {

	@Autowired
	private EmployeeManagementRepositoryContract repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean createEmployee(EmployeeDTO employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		repository.insertIntoEmployeeTable(employee);
		return true;
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {
		Employee employee = repository.selectFromEmployeeTable(employeeId);
		EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class);
		return employeeDto;
	}

	@Override
	public boolean updateEmployee(Long employeeId, EmployeeDTO employeeDto) {
		Employee employeeFromDB = repository.selectFromEmployeeTable(employeeId);
		employeeFromDB.setAddress(employeeDto.getAddress());
		boolean updateIntoEmployeeTable = repository.updateIntoEmployeeTable(employeeFromDB);
		return updateIntoEmployeeTable;
	}

	@Override
	public boolean deleteEmployee(Long employeeId) {
		boolean deleteFromEmployeeTable = repository.deleteFromEmployeeTable(employeeId);
		return deleteFromEmployeeTable;
	}

}
