package com.AcademicaPro.repository;



import com.AcademicaPro.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Additional query methods can be defined here if needed
}
