package com.example.Advanced_Mappings_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Advanced_Mappings_security.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer>{
    
}
