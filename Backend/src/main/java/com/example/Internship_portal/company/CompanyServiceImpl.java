package com.example.Internship_portal.company;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company createCompany(Company companyRegistration) {
		// TODO Auto-generated method stub
		return this.companyRepository.save(companyRegistration);
	}

	@Override
	public Company getCompany(Integer id) {
		Optional<Company> findCompanyOpt=this.companyRepository.findById(id);
		if(findCompanyOpt.isEmpty()) {
			//throws exception
		}
		return findCompanyOpt.get();
		}

	@Override
	public Company findByEmail(String email) {
		Optional<Company> companyOpt = companyRepository.findByEmail(email);
        return companyOpt.orElse(null); // Return company details if found, otherwise return null
	}

	
}
