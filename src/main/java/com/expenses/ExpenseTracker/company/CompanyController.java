package com.expenses.ExpenseTracker.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		companyService.addCompany(company);
		return new ResponseEntity<Company>(new HttpHeaders(), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Company>> getCompanies() {
		List<Company> companies = companyService.getCompanies();
		return new ResponseEntity<List<Company>>(companies, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
		Company company = companyService.getCompanyById(id);
		return new ResponseEntity<Company>(company, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
		Company updatedCompany = companyService.updateCompany(id, company);
		return new ResponseEntity<Company>(updatedCompany, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCompany(@PathVariable Long id) throws CompanyNotFoundException {
		companyService.deleteCompany(id);
		return HttpStatus.OK;
	}
}