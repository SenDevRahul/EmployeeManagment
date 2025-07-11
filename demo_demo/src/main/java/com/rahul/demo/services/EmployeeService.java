package com.rahul.demo.services;

import java.util.List;
import java.util.Optional;

import com.rahul.demo.entities.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();

	void deleteEmployee(Employee employee);
	
	Optional<Employee> getEmployee(String empId);

}
