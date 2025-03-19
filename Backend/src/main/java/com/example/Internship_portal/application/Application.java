package com.example.Internship_portal.application;

import java.time.LocalDate;
import java.util.Date;

import com.example.Internship_portal.company.Company;
import com.example.Internship_portal.internship.Internship;
import com.example.Internship_portal.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {
	 @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;

	    @ManyToOne
	    @JoinColumn(name = "internship_id")
	    //@JsonIgnore
	    private Internship internship;

	    private Date appliedDate;
	    private String status;
	    private LocalDate interviewDate;
	    
	    @ManyToOne
	    @JoinColumn(name = "company_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Company company;
	    
	    
	    
		public Application() {
			super();
		}
		public Application(Long id, Date appliedDate, String status, LocalDate interviewDate) {
			super();
			this.id = id;
			this.appliedDate = appliedDate;
			this.status = status;
			this.interviewDate = interviewDate;
		}
		
		public Application(Long id, Student student, Internship internship, Date appliedDate, String status,
				LocalDate interviewDate, Company company) {
			super();
			this.id = id;
			this.student = student;
			this.internship = internship;
			this.appliedDate = appliedDate;
			this.status = status;
			this.interviewDate = interviewDate;
			this.company=company;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		public Internship getInternship() {
			return internship;
		}
		public void setInternship(Internship internship) {
			this.internship = internship;
		}
		public Date getAppliedDate() {
			return appliedDate;
		}
		public void setAppliedDate(Date appliedDate) {
			this.appliedDate = appliedDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public LocalDate getInterviewDate() {
			return interviewDate;
		}
		public void setInterviewDate(LocalDate localDate) {
			this.interviewDate = localDate;
		}
		public Company getCompany() {
			return this.internship != null ? this.internship.getCompany() : null;
		}
		public void setCompany(Company company) {
			this.company = company;
		}
		
//	
	
		
		
}
