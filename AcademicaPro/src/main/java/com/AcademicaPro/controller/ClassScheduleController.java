package com.AcademicaPro.controller;



import java.util.List;
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

import com.AcademicaPro.classroomService.ClassScheduleService;
import com.AcademicaPro.entity.ClassSchedule;

@RestController
@RequestMapping("/api/classschedules")
public class ClassScheduleController {

    @Autowired
    private ClassScheduleService classScheduleService;

    // Get all class schedules
    @GetMapping
    public List<ClassSchedule> getAllClassSchedules() {
        return classScheduleService.getAllClassSchedules();
    }

    // Get a specific class schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassSchedule> getClassScheduleById(@PathVariable Long id) {
        ClassSchedule classSchedule = classScheduleService.getClassScheduleById(id);
        return ResponseEntity.ok(classSchedule);
    }

    // Create a new class schedule
    @PostMapping
    public ClassSchedule createClassSchedule(@RequestBody ClassSchedule classSchedule) {
        return classScheduleService.createClassSchedule(classSchedule);
    }

    // Update an existing class schedule
    @PutMapping("/{id}")
    public ResponseEntity<ClassSchedule> updateClassSchedule(@PathVariable Long id,
                                                             @RequestBody ClassSchedule updatedClassSchedule) {
        ClassSchedule savedClassSchedule = classScheduleService.updateClassSchedule(id, updatedClassSchedule);
        return ResponseEntity.ok(savedClassSchedule);
    }

    // Delete a class schedule by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClassSchedule(@PathVariable Long id) {
        classScheduleService.deleteClassSchedule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
