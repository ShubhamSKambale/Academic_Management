package com.AcademicaPro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AcademicaPro.classroomService.ClassScheduleService;
import com.AcademicaPro.entity.ClassSchedule;

@RestController
@RequestMapping("/api/schedules")
public class ClassScheduleController {

    @Autowired
    private ClassScheduleService classScheduleService;

    @GetMapping
    public List<ClassSchedule> getAllSchedules() {
        return classScheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Optional<ClassSchedule> getScheduleById(@PathVariable Long id) {
        return classScheduleService.getScheduleById(id);
    }

    @PostMapping
    public ClassSchedule createSchedule(@RequestBody ClassSchedule classSchedule) {
        return classScheduleService.createSchedule(classSchedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        classScheduleService.deleteSchedule(id);
    }
}
