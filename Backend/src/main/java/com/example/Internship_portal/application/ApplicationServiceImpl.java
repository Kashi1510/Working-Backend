package com.example.Internship_portal.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Internship_portal.student.Student;
import com.example.Internship_portal.student.StudentRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationsRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Application applyForInternship(Application application) {
        application.setStatus("Pending");
        return applicationsRepository.save(application);
    }

    @Override
    public List<Application> getApplicationsByInternship(Long internshipId) {
        return applicationsRepository.findByInternshipId(internshipId);
    }

    @Override
    public Application saveApplication(Application application) {
        return applicationsRepository.save(application);
    }

    @Override
    public Application findById(Long applicationId) {
        return applicationsRepository.findById(applicationId).orElse(null);
    }

    @Override
    public List<Application> getApplicationsByStudent(Integer studentId) {
        try {
        	Optional<Student> student = this.studentRepository.findById(studentId);
            // Retrieve applications by student ID
            List<Application> applications = applicationsRepository.findByStudent(student);
            
            // If no applications are found, return an empty list
            if (applications.isEmpty()) {
                return new ArrayList<>();
            }
            return applications;
        } catch (Exception e) {
            // Handle any error that might occur (you can rethrow the exception or return an empty list)
            return new ArrayList<>();
        }
    }

    @Override
    public Application approveOrRejectApplication(Long applicationId, String action) {
        try {
            // Check if the application exists
            Optional<Application> applicationOpt = applicationsRepository.findById(applicationId);
            
            if (applicationOpt.isPresent()) {
                Application application = applicationOpt.get();
                
                // Validate the action before proceeding
                if (action == null || (!action.equals("approve") && !action.equals("reject"))) {
                    throw new IllegalArgumentException("Invalid action. Action must be 'approve' or 'reject'.");
                }
                
                // Approve or reject based on the action
                if (action.equals("approve")) {
                    application.setStatus("Approved");
                    application.setInterviewDate(LocalDate.now().plusDays(7)); // Example: set interview date 7 days from now
                } else if (action.equals("reject")) {
                    application.setStatus("Rejected");
                }

                // Save the updated application back to the database
                return applicationsRepository.save(application);
            } else {
                // Application not found, throw an exception or return null
                throw new RuntimeException("Application not found");
            }
        } catch (Exception e) {
            // Handle the exception or return null (depending on your use case)
            return null;
        }
    }

    

}
