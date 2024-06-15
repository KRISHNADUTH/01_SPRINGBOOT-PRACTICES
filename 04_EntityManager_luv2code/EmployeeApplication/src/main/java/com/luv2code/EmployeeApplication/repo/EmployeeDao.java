package com.luv2code.EmployeeApplication.repo;

import java.util.List;

import com.luv2code.EmployeeApplication.model.Employee;

public interface EmployeeDao {
    public void insertEmplyeeList(List<Employee> employees);

    public Employee findById(Integer id);

    public Employee updatEmployee(Employee employee);

    public void deletEmployee(Employee employee);
}
