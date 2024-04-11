package com.expenses.ExpenseTracker.expense;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ExpenseService {
	@Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(int id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.orElse(null);
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(int id, Expense updatedExpense) throws ExpenseNotFoundException {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            updatedExpense.setId(id);
            return expenseRepository.save(updatedExpense);
        } else {
            throw new ExpenseNotFoundException("The entered id :"+id+" is not present");
        }
    }

    public boolean deleteExpense(int id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            expenseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
