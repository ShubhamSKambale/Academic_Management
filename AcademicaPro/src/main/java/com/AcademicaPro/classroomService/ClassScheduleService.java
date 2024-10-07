package com.AcademicaPro.classroomService;

import com.AcademicaPro.entity.ClassSchedule;
import com.AcademicaPro.repository.ClassScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassScheduleService {

    @Autowired
    private ClassScheduleRepository classScheduleRepository;

    public List<ClassSchedule> getAllSchedules() {
        return classScheduleRepository.findAll();
    }

    public Optional<ClassSchedule> getScheduleById(Long id) {
        return classScheduleRepository.findById(id);
    }

    public ClassSchedule createSchedule(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }

    public void deleteSchedule(Long id) {
        classScheduleRepository.deleteById(id);
    }
}
