package com.example.final_practice.repo;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.final_practice.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class StudentRepoImpl implements StudentRepo {
    EntityManager entityManager;

    public StudentRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    } 
    @Override
    public void createStudent(Student student) {
        entityManager.persist(student);
    }
    @Override
    public Student readStudent(Integer id) {
        return entityManager.find(Student.class, id);
    }
    @Override
    public Student updaStudent(Student student) {
        return entityManager.merge(student);
    }
    @Override
    public Integer updateStudentLastName() {
        Integer numOfRowsUpdated = entityManager.createQuery("UPDATE Student s SET s.lastName='Tester'").executeUpdate();
        return numOfRowsUpdated;
    }
    @Override
    public Student deleteStudentById(Integer id) {
        Student studentToBeDeleted = entityManager.find(Student.class, id);
        if (studentToBeDeleted!=null) {
            Query query = entityManager.createQuery("DELETE FROM Student s WHERE s.id = :id");// We cannot use TypedQuery<Student> here since Delete opertations will not return anything.
            query.setParameter("id", id);
            query.executeUpdate();
        }
        return studentToBeDeleted;
    }
    @Override
    public Integer countStudent(String lastName) {
        // TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName = ?1",
        //         Student.class);
        // theQuery.setParameter(1, lastName);
        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName LIKE :lastName",
                Student.class);
        theQuery.setParameter("lastName", "%"+lastName+"%");
        List<Student> students = theQuery.getResultList();
        return students.size();
    }
    
}
