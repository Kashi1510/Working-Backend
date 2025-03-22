package com.example.Internship_portal.internship;
import java.util.ArrayList;
import java.util.Collection;

import com.example.Internship_portal.application.Application;
import com.example.Internship_portal.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String companyname;
    private String description;
    
    @ManyToOne
//    @JoinColumn(name = "company_id") // This should match the column name in the database
    private Company company;
    
    // Add the company field
   // private String companyName; // Add company name for simplicity
    @JsonIgnore
    @OneToMany(mappedBy = "internship", cascade = CascadeType.ALL)
    private Collection<Application> applications = new ArrayList<>();
    
    
    public Internship() {
		super();
	}
    
    public Internship(Long id, String title, String description, String companyName,
			Collection<Application> applications,String companyname) {
		super();
		this.id = id;
		this.companyname=companyname;

		this.description = description;
    	
		this.applications = applications;
		
	}
    
    
	

	// Getters and setters

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Application> getApplications() {
		return applications;
	}

	public void setApplications(Collection<Application> applications) {
		this.applications = applications;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
//	

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	

}
