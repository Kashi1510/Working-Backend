package com.example.Internship_portal.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Internship_portal.student.Student;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	 //List<Applications> findByStudentEmail(String studentEmail);

	List<Application> findByStudent(Optional<Student> student);

	List<Application> findByInternshipId(Long internshipId);

}
