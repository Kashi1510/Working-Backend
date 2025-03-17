package com.example.Internship_portal.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 

public class StudentController {
	
@Autowired
private StudentService studentService;

@PostMapping("/register")
public Student registerStudent( @RequestBody Student stuRegistration) {
	return studentService.createStudent(stuRegistration);
}

@GetMapping("/register/{id}")
public Student getStudentById(@PathVariable("id") Integer id) {
    return this.studentService.getStudentById(id);
}
}