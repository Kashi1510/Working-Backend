package com.example.Internship_portal.login;

import com.example.Internship_portal.company.Company;
import com.example.Internship_portal.company.CompanyService;
import com.example.Internship_portal.student.Student;
import com.example.Internship_portal.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CompanyService companyService;

    @Override
    public Object login(String email, String password) {
    	// Check student record
        Student student = studentService.findByEmail(email);
        // Check company record
        Company company = companyService.findByEmail(email);

        // Ensure email is unique across both tables
        if (student != null && company != null) {
            throw new IllegalStateException("Error: Duplicate email found in both student and company records!");
        }

        // If email belongs to a student
        if (student != null) {
            return student.getPassword().equals(password) ? student : null;
        }

        // If email belongs to a company
        if (company != null) {
            return company.getPassword().equals(password) ? company : null;
        }

        return null; // No user found with given email
    }
}
