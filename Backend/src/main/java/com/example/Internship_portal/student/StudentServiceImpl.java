package com.example.Internship_portal.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student stuRegistration) {
        return this.studentRepository.save(stuRegistration);
    }

 
    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> foundStuOpt = this.studentRepository.findById(id);
        return foundStuOpt.orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    @Override
    public Student findByEmail(String email) {
        Optional<Student> studentOpt = this.studentRepository.findByEmail(email);
        return studentOpt.orElse(null); // Return student details if found, otherwise return null
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

	
	}
