package com.fz.ExpenseTracker.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository companyrepository;

	public Company addCompany(Company company) {
		Company com = companyrepository.save(company);
		return com;
	}

	public List<Company> getCompanies() {
		return (List<Company>) companyrepository.findAll();
	}

	public Company getCompanyById(int id) {
		Optional<Company> comp = companyrepository.findById(id);
		if (comp.isPresent()) {
			Company com = comp.get();
			return com;
		} else {
			throw new CompanyNotFoundException("Given data is not found");
		}
	}

	public Company updateCompany(int id, Company company) {
		Optional<Company> com = companyrepository.findById(id);
		if (com.isPresent()) {
			Company comp = com.get();
			if (company.getName() != null) {
				comp.setName(company.getName());
			}
			if (company.getAddress() != null) {
				comp.setAddress(company.getAddress());
			}
			if (company.getLegalName() != null) {
				comp.setLegalName(company.getLegalName());
			}
			if (company.getEmail() != null) {
				comp.setEmail(company.getEmail());
			}
			if (company.getPhoneNumber() != null) {
				comp.setPhoneNumber(company.getPhoneNumber());
			}
			if (company.getCurrency() != null) {
				comp.setCurrency(company.getCurrency());
			}
			if (company.getType() != null) {
				comp.setType(company.getType());
			}

			return companyrepository.save(comp);

		}else {
			throw new CompanyNotFoundException("Given data is not found");
		}
	}

	public boolean deleteCompany(int id) {
		Optional<Company> com=companyrepository.findById(id);
		if(com.isPresent()) {
			companyrepository.deleteById(id);
			return true;
		}else {
			throw new CompanyNotFoundException("Given data is not found");
		}
	}

}
