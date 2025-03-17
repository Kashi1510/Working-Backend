package com.example.Internship_portal.internship;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternshipServiceImpl implements InternshipService {
	
	@Autowired
	private InternshipRepository internshipRepository;
	
	  public void InternshipService(InternshipRepository internshipRepository) {
	        this.internshipRepository = internshipRepository;
	    }

	@Override
	public List<Internship> getAllInternships() {
		// TODO Auto-generated method stub
		return internshipRepository.findAll();
	}

	@Override
	public Internship postInternship(Internship internship) {
		// TODO Auto-generated method stub
		 return internshipRepository.save(internship);
	}

}
