package com.example.final_practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.final_practice.model.Student;
import com.example.final_practice.repo.StudentRepo;

@SpringBootApplication
public class FinalPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalPracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentRepo studentRepo)
	{
		return runner -> {
			// studentRepo.createStudent(new Student("John", "Khureshi", "john@gail.com"));
			// studentRepo.createStudent(new Student("Boss", "Mart", "boss@gail.com"));
			// studentRepo.createStudent(new Student("MIwe", "jamer", "Mile@gail.com"));
			// studentRepo.createStudent(new Student("Smith", "null", "smith@gail.com"));
			// studentRepo.createStudent(new Student("Dan", "albert", "dane@gail.com"));
			// studentRepo.createStudent(new Student("Laoser", "Samuel", "laoser@gail.com"));
			// studentRepo.createStudent(new Student("Lefgot", "Noker", "Leftgo@gail.com"));
			// studentRepo.createStudent(new Student("Crystal", "clear", "crystal@gail.com"));

			// Student student = studentRepo.readStudent(4);
			// System.out.println("Student with id 4 is - " + student);

			// studentRepo.updaStudent(new Student(7, "L", "Lawliet", "l@gmail.com"));
			// System.out.println("Updated student is - "+studentRepo.readStudent(7));

			// Update all students last name to 'Tester'
			// System.out.println( studentRepo.updateStudentLastName());

			// Delete student with ID 6
			// System.out.println("Deleted student is - "+studentRepo.deleteStudentById(6));

			System.out.println(studentRepo.countStudent("Tester"));
		};
	}
}
