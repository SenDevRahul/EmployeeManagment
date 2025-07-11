package com.rahul.demo.repogetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.demo.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{

}
