package com.rahul.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.demo.entities.Employee;
import com.rahul.demo.repogetories.EmployeeRepo;
import com.rahul.demo.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}
	

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}


	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		 employeeRepo.delete(employee);
	}


	@Override
	public Optional<Employee> getEmployee(String empId) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(empId);
	}

}
