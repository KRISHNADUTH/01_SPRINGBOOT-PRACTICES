package com.luv2code.EmployeeApplication;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.luv2code.EmployeeApplication.model.Employee;
import com.luv2code.EmployeeApplication.repo.EmployeeDaoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@EnableTransactionManagement
@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	EmployeeDaoImpl employeeDaoImpl;
	EntityManager entityManager;

	public EmployeeApplication(EmployeeDaoImpl employeeDaoImpl, EntityManager entityManager) {
		this.employeeDaoImpl = employeeDaoImpl;
		this.entityManager = entityManager;
	}


	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDaoImpl employeeDaoImpl) {
		return  runner->{
			System.out.println("Hello world !");
			System.out.println("People with work mail - " + countOfPeopleWithOfcMail(employeeDaoImpl));
			// System.out.println(removeEmployeeWithOrgMail() + " employees removed");
		};
	}

	// @Transactional  // Transactinoal annotation will not work here we have to call function from Service leyer and use transactional annotation there.
	// public int removeEmployeeWithOrgMail() {
	// 	return entityManager.createQuery("DELETE FROM Employee e WHERE e.email LIKE :email")
	// 			.setParameter("email", "%" + "org" + "%").executeUpdate();
	// }


	public int countOfPeopleWithOfcMail(EmployeeDaoImpl employeeDaoImpl){
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.email LIKE :workemail", Employee.class);
		query.setParameter("workemail", "%" + "workplace" + "%");
		List<Employee> employees = query.getResultList();

		return employees.size();
	}
}
