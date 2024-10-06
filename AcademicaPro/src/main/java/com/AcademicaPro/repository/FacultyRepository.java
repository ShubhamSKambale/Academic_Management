package com.AcademicaPro.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AcademicaPro.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    // Additional query methods can be defined here
}
