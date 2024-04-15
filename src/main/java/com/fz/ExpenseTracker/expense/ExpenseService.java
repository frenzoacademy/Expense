package com.fz.ExpenseTracker.expense;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.category.CategoryRepository;
import com.fz.ExpenseTracker.service.ServiceDTO;
import com.fz.ExpenseTracker.service.Services;
@Service
public class ExpenseService {
	@Autowired
    private ExpenseRepository expenseRepository;

 

	public List<Expense> getAllExpenses() {
		List<Expense> expenses=expenseRepository.findAll();
		List<Expense> listOfExpenses=new ArrayList<>();
		for(Expense ex:expenses) {

			Expense e=new Expense();
			e.setId(ex.getId());
			e.setAmount(ex.getAmount());
			Optional<Category> category=categoryRepository.findById(ex.getCategory());
			if(category.isPresent()) {
				Category c=category.get();
				e.setCategoryEntity(c);
				System.out.println(",,,,,,,,,,,,"+c.getName());
			}
			e.setDate_time(ex.getDate_time());
			e.setDescription(ex.getDescription());
			e.setPaid_account(ex.getPaid_account());
			e.setReference(ex.getReference());
			listOfExpenses.add(e);
			System.out.println(e.getCategoryEntity()+"---------");
		}
		return listOfExpenses;
	}

    public Expense getExpenseById(int id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.orElse(null);
    }

//    public Expense addExpense(Expense expense) {
//    	LocalDateTime date=LocalDateTime.now();
//    	expense.setDate_time(date);
//        return expenseRepository.save(expense);
//    }
    @Autowired
    CategoryRepository categoryRepository;
    
    public void createExpense(Expense expenseRequest) {
        Category category = categoryRepository.findById(expenseRequest.getCategory())
                .orElseThrow();

        Expense expense = new Expense();
        expense.setAmount(expenseRequest.getAmount());
        expense.setDate_time(LocalDateTime.now()); 
        expense.setPaid_account(expenseRequest.getPaid_account());
        expense.setReference(expenseRequest.getReference());
        expense.setDescription(expenseRequest.getDescription());
        
        expense.setCategory(category.getId());
        
        expenseRepository.save(expense);
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