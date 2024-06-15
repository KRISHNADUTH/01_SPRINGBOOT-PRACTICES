package com.luv2code.EmployeeApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.EmployeeApplication.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    
}
