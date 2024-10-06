package com.AcademicaPro.classroomService;



import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcademicaPro.entity.ClassSchedule;
import com.AcademicaPro.repository.ClassScheduleRepository;

@Service
public class ClassScheduleService {

    @Autowired
    private ClassScheduleRepository classScheduleRepository;

    // Get all class schedules
    public List<ClassSchedule> getAllClassSchedules() {
        return classScheduleRepository.findAll();
    }

    // Get a specific class schedule by ID
    public ClassSchedule getClassScheduleById(Long id) {
        return classScheduleRepository.findById(id)
                .orElseThrow();
    }

    // Create a new class schedule
    public ClassSchedule createClassSchedule(ClassSchedule classSchedule) {
        return classScheduleRepository.save(classSchedule);
    }

    // Update an existing class schedule
    public ClassSchedule updateClassSchedule(Long id, ClassSchedule updatedClassSchedule) {
        ClassSchedule classSchedule = getClassScheduleById(id);
        
        // Update fields
        classSchedule.setSubject(updatedClassSchedule.getSubject());
        classSchedule.setStartTime(updatedClassSchedule.getStartTime());
        classSchedule.setEndTime(updatedClassSchedule.getEndTime());
        classSchedule.setRoom(updatedClassSchedule.getRoom());

        return classScheduleRepository.save(classSchedule);
    }

    // Delete a class schedule by ID
    public void deleteClassSchedule(Long id) {
        ClassSchedule classSchedule = getClassScheduleById(id);
        classScheduleRepository.delete(classSchedule);
    }
}
