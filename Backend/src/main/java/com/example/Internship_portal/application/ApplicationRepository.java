package com.example.Internship_portal.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Internship_portal.student.Student;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	 //List<Applications> findByStudentEmail(String studentEmail);

	List<Application> findByStudent(Optional<Student> student);

	List<Application> findByInternshipId(Long internshipId);
	
	@Query("SELECT a FROM Application a JOIN FETCH a.internship i JOIN FETCH i.company WHERE a.student.id = :studentId")
	List<Application> findByStudentIdWithCompany(@Param("studentId") Long studentId);


}
