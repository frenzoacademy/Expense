package com.fz.ExpenseTracker.expense;

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

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	 @Autowired
	    private ExpenseService expenseService;

	    @GetMapping
	    public ResponseEntity<List<Expense>> getAllExpenses() {
	        List<Expense> expenses = expenseService.getAllExpenses();
	        return new ResponseEntity<>(expenses, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Expense> getExpenseById(@PathVariable int id) {
	        Expense expense = expenseService.getExpenseById(id);
	        if (expense != null) {
	            return new ResponseEntity<>(expense, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
	        Expense createdExpense = expenseService.addExpense(expense);
	        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Expense> updateExpense(@PathVariable int id, @RequestBody Expense expense) throws ExpenseNotFoundException {
	        Expense updatedExpense = expenseService.updateExpense(id, expense);
	        if (updatedExpense != null) {
	            return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteExpense(@PathVariable int id) {
	        boolean deleted = expenseService.deleteExpense(id);
	        if (deleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
