package com.luv2code.EmployeeApplication.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.luv2code.EmployeeApplication.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    EntityManager entityManager;
    
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insertEmplyeeList(List<Employee> employees) {
        for(Employee employee : employees)
            entityManager.persist(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee updatEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deletEmployee(Employee employee) {
        entityManager.remove(employee);
    }
    
}
