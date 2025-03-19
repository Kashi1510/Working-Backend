package com.example.Internship_portal.internship;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Internship_portal.application.Application;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long> {

	


}
