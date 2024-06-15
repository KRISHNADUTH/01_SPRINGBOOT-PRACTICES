package com.example.Advanced_Mappings_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Advanced_Mappings_security.model.InstructorDetail;

public interface InstructorDetailRepo extends JpaRepository<InstructorDetail, Integer>
{
    
}
