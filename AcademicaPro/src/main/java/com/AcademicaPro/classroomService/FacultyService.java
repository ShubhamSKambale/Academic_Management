package com.AcademicaPro.classroomService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcademicaPro.entity.Faculty;
import com.AcademicaPro.repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {
        return facultyRepository.findById(id)
                .map(faculty -> {
                    faculty.setName(updatedFaculty.getName());
                    faculty.setDepartment(updatedFaculty.getDepartment());
                    faculty.setEmail(updatedFaculty.getEmail());
                    faculty.setPhone(updatedFaculty.getPhone());
                    return facultyRepository.save(faculty);
                })
                .orElseThrow();
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
