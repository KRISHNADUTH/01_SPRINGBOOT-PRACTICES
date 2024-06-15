package com.luv2code.EmployeeApplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.EmployeeApplication.Service.EmployeeService;
import com.luv2code.EmployeeApplication.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService, EntityManager entityManager) {
        this.employeeService = employeeService;
        this.entityManager = entityManager;
    }

    EntityManager entityManager;

    @GetMapping("/")
    public String home() {
        return "Welcome to SpringBoot world";
    }

    @PostMapping("/employee")
    public ResponseEntity<String> insertEmplyeeList(@RequestBody List<Employee> employees) {
        return employeeService.insertEmplyeeList(employees);
    }

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable int id)
    {
        return employeeService.findById(id);
    }

    @PutMapping("/employee")
    public Employee updatEmployee(@RequestBody Employee employee) {
        return employeeService.updatEmployee(employee);
    }

    @DeleteMapping("/employee")
    public Employee deleteEmployee(@RequestBody Employee employee) {
        return employeeService.deleteEmployee(employee);
    }

    @Transactional
    @DeleteMapping("removeemployeewithorgmail")
	public int removeEmployeeWithOrgMail() {
		return entityManager.createQuery("DELETE FROM Employee e WHERE e.email LIKE :email")
				.setParameter("email", "%" + "org" + "%").executeUpdate();
	}
}
