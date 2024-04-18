package com.fz.ExpenseTracker.income;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/income")
public class IncomeController {
	@Autowired
	private IncomeService incomeService;

	@GetMapping
	public ResponseEntity<List<Income>> getAllIncomes() {
		List<Income> incomes = incomeService.getAllIncomes();
		return new ResponseEntity<>(incomes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Income> getIncomeById(@PathVariable int id) throws IncomeNotFoundException {
		Income income = incomeService.getIncomeById(id);
		if (income != null) {
			return new ResponseEntity<>(income, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> createIncome(@RequestBody IncomeDTO income) {
		incomeService.createIncome(income);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteIncome(@PathVariable int id) {
		boolean deleted = incomeService.deleteIncome(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
