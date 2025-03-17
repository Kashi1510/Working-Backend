package com.example.Internship_portal.student;

import java.util.ArrayList;
import java.util.Collection;

import com.example.Internship_portal.application.Application;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stu_registration")
public class Student {
	
	@Id
    @GeneratedValue
   
	private Integer id;
	private String firstName;
	 private String lastName;
	 private String email;
	 private String password;
	 private String sslcPercentage;
	 private String pucPercentage;
	 private String  degreeCgpa;
	 private String   skills;
	 
	 @OneToMany
	 private Collection<Application> applications=new ArrayList<>();
	 
	public Student() {
		super();
	}
	public Student(Integer id, String firstName, String lastName, String email, String password,
			String sslcPercentage, String pucPercentage, String degreeCgpa, String skills) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.sslcPercentage = sslcPercentage;
		this.pucPercentage = pucPercentage;
		this.degreeCgpa = degreeCgpa;
		this.skills = skills;
	}
	
	
	
	public Collection<Application> getApplications() {
		return applications;
	}
	public void setApplications(Collection<Application> applications) {
		this.applications = applications;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSslcPercentage() {
		return sslcPercentage;
	}
	public void setSslcPercentage(String sslcPercentage) {
		this.sslcPercentage = sslcPercentage;
	}
	public String getPucPercentage() {
		return pucPercentage;
	}
	public void setPucPercentage(String pucPercentage) {
		this.pucPercentage = pucPercentage;
	}
	public String getDegreeCgpa() {
		return degreeCgpa;
	}
	public void setDegreeCgpa(String degreeCgpa) {
		this.degreeCgpa = degreeCgpa;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
		
}