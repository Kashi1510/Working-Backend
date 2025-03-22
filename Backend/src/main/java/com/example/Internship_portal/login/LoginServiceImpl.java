package com.example.Internship_portal.login;

import com.example.Internship_portal.company.Company;
import com.example.Internship_portal.company.CompanyService;
import com.example.Internship_portal.student.Student;
import com.example.Internship_portal.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private  StudentService studentService;

    @Autowired
    private CompanyService companyService;

    @Override
    public ResponseEntity<?> login(String email, String password) {
        Student student = studentService.findByEmail(email);
        Company company = companyService.findByEmail(email);

        // Ensure email is not present in both tables
        if (student != null && company != null) {
            return ResponseEntity.badRequest().body("{\"error\": \"Duplicate email found in both student and company records!\"}");
        }

        // If email belongs to a student
        if (student != null && student.getPassword().equals(password)) {
//            return ResponseEntity.ok("{\"dashboard\": \"/student-dashboard\"}");
        	return ResponseEntity.ok(student);
        }

        // If email belongs to an employer
        if (company != null && company.getPassword().equals(password)) {
//           return ResponseEntity.ok("{\"dashboard\": \"/employer-dashboard\"}");
        	 return ResponseEntity.ok(company);
        }

        return ResponseEntity.status(401).body("{\"error\": \"Invalid email or password\"}");
    }
}
