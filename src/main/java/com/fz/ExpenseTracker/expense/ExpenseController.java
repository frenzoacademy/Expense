package com.fz.ExpenseTracker.expense;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.service.ServiceNotFoundException;
import com.fz.ExpenseTracker.service.Services;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	 @Autowired
	    private ExpenseService expenseService;

	    @GetMapping
	    @PreAuthorize("hasAuthority('ADMIN')")
	    public ResponseEntity<List<Expense>> getAllExpenses() {
	        List<Expense> expenses = expenseService.getAllExpenses();
	        return new ResponseEntity<>(expenses, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    @PreAuthorize("hasAuthority('ADMIN')")
	    public ResponseEntity<Expense> getExpenseById(@PathVariable int id) throws ExpenseNotFoundException {
	        Expense expense = expenseService.getExpenseById(id);
	        if (expense != null) {
	            return new ResponseEntity<>(expense, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @PostMapping
	    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	    @Transactional
	    public ResponseEntity<?> createExpense(@RequestBody ExpenseDTO expense) {
	    	expenseService.createExpense(expense);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
		public ResponseEntity<Expense> updateExpense(@PathVariable int id, @RequestBody Expense expenses) throws ServiceNotFoundException, ExpenseNotFoundException {
	    	Expense expense = expenseService.updateExpense(id, expenses);
			if (expense != null) {
				return ResponseEntity.ok(expense);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

	    @DeleteMapping("/{id}")
	    @PreAuthorize("hasAuthority('ADMIN')")
	    public ResponseEntity<HttpStatus> deleteExpense(@PathVariable int id) {
	        boolean deleted = expenseService.deleteExpense(id);
	        if (deleted) {
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
