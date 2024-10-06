package com.AcademicaPro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AcademicaPro.classroomService.ClassroomService;
import com.AcademicaPro.entity.Classroom;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	// Get all classrooms
	@GetMapping
	public ResponseEntity<List<Classroom>> getAllClassrooms() {
		List<Classroom> classrooms = classroomService.getAllClassrooms();
		return new ResponseEntity<>(classrooms, HttpStatus.OK);
	}

	// Get classroom by ID
	@GetMapping("/{id}")
	public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
		Optional<Classroom> classroom = classroomService.getClassroomById(id);
		return classroom.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// Create a new classroom
	@PostMapping
	public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
		Classroom createdClassroom = classroomService.createClassroom(classroom);
		return new ResponseEntity<>(createdClassroom, HttpStatus.CREATED);
	}

	// Update an existing classroom
	@PutMapping("/{id}")
	public ResponseEntity<Classroom> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom) {
		Optional<Classroom> existingClassroom = classroomService.getClassroomById(id);
		if (existingClassroom.isPresent()) {
			Classroom updatedClassroom = classroomService.updateClassroom(id, classroom);
			return new ResponseEntity<>(updatedClassroom, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a classroom by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
		Optional<Classroom> existingClassroom = classroomService.getClassroomById(id);
		if (existingClassroom.isPresent()) {
			classroomService.deleteClassroom(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
