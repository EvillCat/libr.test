package com.evillcat.libr.test.student.service;

import com.evillcat.libr.test.student.model.Student;
import com.evillcat.libr.test.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudentsList(){
        return studentRepo.findAll();
    }
}
