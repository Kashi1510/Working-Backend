package com.example.Internship_portal.internship;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Internship_portal.application.Application;
import com.example.Internship_portal.application.ApplicationService;

@RestController
@RequestMapping("/internships")
@CrossOrigin("*")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private ApplicationService applicationsService;

    // Get all internships
    @GetMapping
    public List<Internship> getInternships() {
        return internshipService.getAllInternships();
    }

    // Post an internship
    @PostMapping
    public Internship postInternship(@RequestBody Internship internship) {
        return internshipService.postInternship(internship);
    }

    // Get applicants for a specific internship
    @GetMapping("/{internshipId}/applicants")
    public List<Application> getApplicants(@PathVariable Long internshipId) {
        return applicationsService.getApplicationsByInternship(internshipId);
    }

    // Approve or reject an application
    @PostMapping("/{internshipId}/applications/{applicationId}/approve")
    public Application approveApplication(@PathVariable Long internshipId, @PathVariable Long applicationId) {
        Application application = applicationsService.findById(applicationId);
        if (application != null && application.getInternship().getId().equals(internshipId)) {
            application.setStatus("Accepted");
            return applicationsService.saveApplication(application);
        }
        return null;
    }

    @PostMapping("/{internshipId}/applications/{applicationId}/reject")
    public Application rejectApplication(@PathVariable Long internshipId, @PathVariable Long applicationId) {
        Application application = applicationsService.findById(applicationId);
        if (application != null && application.getInternship().getId().equals(internshipId)) {
            application.setStatus("Rejected");
            return applicationsService.saveApplication(application);
        }
        return null;
    }
}
