package com.rahul.demo.restController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.demo.entities.Employee;
import com.rahul.demo.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestContoller {

	
	@Autowired
	EmployeeService impService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployee( @RequestBody Employee employee){
		String randomNum = UUID.randomUUID().toString();
		employee.setId(randomNum);
	  Employee employee2=impService.saveEmployee(employee);
	  return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<?> getEmployee( ){
	  List<Employee> employee2=impService.getAllEmployee();
	  return ResponseEntity.ok(employee2);
	}
	
	@GetMapping("/deleteEmployee/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String  empId){
	  impService.deleteEmployee(Employee.builder().id(empId).build());
	  return ResponseEntity.ok(true);
	}
	
	@GetMapping("/getEmployee/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable String  empId){
	   Optional<Employee> employee= impService.getEmployee(empId);
	  return ResponseEntity.ok(employee.get());
	}
	
	@PostMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee( @RequestBody Employee employee){
//		String randomNum = UUID.randomUUID().toString();
//		employee.setId(randomNum);
	  Employee employee2=impService.saveEmployee(employee);
	  return ResponseEntity.ok(employee);
	}
}
