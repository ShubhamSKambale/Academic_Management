package com.AcademicaPro.classroomService;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcademicaPro.entity.Classroom;
import com.AcademicaPro.repository.ClassroomRepository; // Ensure the correct package

@Service
public class ClassroomService {

	@Autowired
	private ClassroomRepository classroomRepository;

	public List<Classroom> getAllClassrooms() {
		return classroomRepository.findAll();
	}

	public Optional<Classroom> getClassroomById(Long id) {
		return classroomRepository.findById(id);
	}

	public Classroom createClassroom(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

	public Classroom updateClassroom(Long id, Classroom updatedClassroom) {
		// Retrieve the existing classroom
		Classroom classroom = classroomRepository.findById(id).orElseThrow();

		// Update fields
		classroom.setName(updatedClassroom.getName());
		classroom.setCapacity(updatedClassroom.getCapacity());

		// Save and return the updated classroom
		return classroomRepository.save(classroom);
	}

	public void deleteClassroom(Long id) {
		classroomRepository.deleteById(id);
	}
}
