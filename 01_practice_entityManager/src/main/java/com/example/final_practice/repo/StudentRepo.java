package com.example.final_practice.repo;

import com.example.final_practice.model.Student;

public interface StudentRepo {
    public void createStudent(Student student);

    public Student readStudent(Integer id);

    public Student updaStudent(Student student);

    public Integer updateStudentLastName();

    public Student deleteStudentById(Integer id);

    public Integer countStudent(String lastName);
}
