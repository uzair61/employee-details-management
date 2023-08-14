package com.qtechlabs.employeemanagement.service;

import com.qtechlabs.employeemanagement.dto.EmployeeDTO;

public interface EmployeeManagementServiceContract {

	public boolean createEmployee(EmployeeDTO employeeDto);

	public EmployeeDTO getEmployee(Long employeeId);

	public boolean updateEmployee(Long employeeId, EmployeeDTO employeeDto);

	public boolean deleteEmployee(Long employeeId);

}
