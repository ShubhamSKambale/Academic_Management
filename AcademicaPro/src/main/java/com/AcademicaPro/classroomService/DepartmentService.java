package com.AcademicaPro.classroomService;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcademicaPro.entity.Department;
import com.AcademicaPro.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        return departmentRepository.findById(id).map(department -> {
            department.setName(updatedDepartment.getName());
            department.setDescription(updatedDepartment.getDescription());
            return departmentRepository.save(department);
        }).orElseThrow();
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
