package com.luv2code.EmployeeApplication.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luv2code.EmployeeApplication.model.Employee;
import com.luv2code.EmployeeApplication.repo.EmployeeDaoImpl;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EmployeeService {

    EmployeeDaoImpl employeeDaoImpl;

    public EmployeeService(EmployeeDaoImpl employeeDaoImpl) {
        this.employeeDaoImpl = employeeDaoImpl;
    }

    @Transactional
    public ResponseEntity<String> insertEmplyeeList(List<Employee> employees) {
        if (employees != null) {
            employeeDaoImpl.insertEmplyeeList(employees);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("Please input employee details......",HttpStatus.BAD_REQUEST);
    }

    public Employee findById(int id) {
        return employeeDaoImpl.findById(id);
    }

    public Employee updatEmployee(Employee employee) {
        return employeeDaoImpl.updatEmployee(employee);
    }

    public Employee deleteEmployee(Employee employee) {
        Employee employeeToBeDeleted = employeeDaoImpl.findById(employee.getId());
        employeeDaoImpl.deletEmployee(employeeToBeDeleted);
        return employeeToBeDeleted;
    }
    
}