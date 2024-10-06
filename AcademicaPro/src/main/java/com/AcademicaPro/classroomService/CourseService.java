package com.AcademicaPro.classroomService;



import com.AcademicaPro.entity.Course;
import com.AcademicaPro.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setTitle(updatedCourse.getTitle());
                    course.setDescription(updatedCourse.getDescription());
                    course.setCredits(updatedCourse.getCredits());
                    return courseRepository.save(course);
                })
                .orElseThrow();
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
