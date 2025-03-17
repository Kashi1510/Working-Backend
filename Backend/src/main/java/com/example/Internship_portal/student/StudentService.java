package com.example.Internship_portal.student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student stuRegistration);

    // ✅ Fixed: Now correctly returns a list of students
    List<Student> getAllStudents();

    // ✅ Fixed: Renamed method to clarify it's fetching a single student
    Student getStudentById(Integer id);

    Student findByEmail(String email);


}
