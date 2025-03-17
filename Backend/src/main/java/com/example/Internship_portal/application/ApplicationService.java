package com.example.Internship_portal.application;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.Internship_portal.student.Student;

public interface ApplicationService {
    Application applyForInternship(Application application);
    List<Application> getApplicationsByInternship(Long internshipId);
    Application saveApplication(Application application);
    Application findById(Long applicationId);
	List<Application> getApplicationsByStudent(Integer studentId);
	Application approveOrRejectApplication(Long applicationId, String action);
}
