package com.AcademicaPro.classroomService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AcademicaPro.entity.Subject;

import com.AcademicaPro.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {
        return subjectRepository.findById(id).map(subject -> {
            subject.setName(updatedSubject.getName());
            subject.setDescription(updatedSubject.getDescription());
            subject.setCredits(updatedSubject.getCredits());
            return subjectRepository.save(subject);
        }).orElseThrow();
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}

