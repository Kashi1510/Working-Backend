package com.example.Internship_portal.company;

import java.util.ArrayList;
import java.util.Collection;

import com.example.Internship_portal.internship.Internship;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue
	private Integer id;
	private String companyname;
	private String city;
	private String email;
	private String password;
	private String address;
	
	@OneToMany
	Collection<Internship> internships = new ArrayList<>();

	public Company() {
		super();
	}

	public Company(Integer id, String companyname, String city, String email, String password,
			String address) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.city = city;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	

	public Collection<Internship> getInternships() {
		return internships;
	}

	public void setInternships(Collection<Internship> internships) {
		this.internships = internships;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
