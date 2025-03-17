package com.example.Internship_portal.internship;

import java.util.List;

public interface InternshipService {

	List<Internship> getAllInternships();

	Internship postInternship(Internship internship);

}
