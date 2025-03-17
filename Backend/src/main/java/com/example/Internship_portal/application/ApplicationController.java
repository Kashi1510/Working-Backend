package com.example.Internship_portal.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Internship_portal.application.Application;
import com.example.Internship_portal.application.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin("*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

//  
    @PostMapping("/apply")
    public ResponseEntity<Application> applyForInternship(@RequestBody Application application) {
        try {
            Application savedApplication = applicationService.applyForInternship(application);
            return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

  
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Application>> getApplicationsByStudent(@PathVariable Integer studentId) {
        try {
            List<Application> applications = applicationService.getApplicationsByStudent(studentId);
            if (applications.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

   
    @PutMapping("/approve-reject/{applicationId}")
    public ResponseEntity<Application> approveOrRejectApplication(@PathVariable Long applicationId,
                                                                   @RequestParam String action) {
        try {
            Application updatedApplication = applicationService.approveOrRejectApplication(applicationId, action);
            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
