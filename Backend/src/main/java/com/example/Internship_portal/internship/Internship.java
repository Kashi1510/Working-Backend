package com.example.Internship_portal.internship;
import java.util.ArrayList;
import java.util.Collection;

import com.example.Internship_portal.application.Application;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    
    // Add the company field
   // private String companyName; // Add company name for simplicity
    @JsonIgnore
    @OneToMany(mappedBy = "internship", cascade = CascadeType.ALL)
    private Collection<Application> applications = new ArrayList<>();
    
    
    public Internship() {
		super();
	}
    
    public Internship(Long id, String title, String description, String companyName,
			Collection<Application> applications) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
//		this.companyName = companyName;
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

//	public String getCompanyName() {
//        return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }

    // other fields and methods...
}
