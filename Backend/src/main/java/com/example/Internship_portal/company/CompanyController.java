package com.example.Internship_portal.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
//@CrossOrigin(origins = "http://localhost:4200") 
@CrossOrigin("*")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/internship")
	public Company registerCompany(@RequestBody Company companyRegistration) {
		return companyService.createCompany(companyRegistration);
	}
	
	@GetMapping("/internship/{id}")
	public Company getCompany(@PathVariable ("id") Integer id) {
		return this.companyService.getCompany(id);
	}
}
