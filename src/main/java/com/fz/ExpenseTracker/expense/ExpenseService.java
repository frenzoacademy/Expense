package com.fz.ExpenseTracker.expense;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.reflect.Field;

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
		
			}
			e.setDate_time(ex.getDate_time());
			e.setDescription(ex.getDescription());
			e.setPaid_account(ex.getPaid_account());
			e.setReference(ex.getReference());
			listOfExpenses.add(e);
		}
		return listOfExpenses;
	}

    public Expense getExpenseById(int id) throws ExpenseNotFoundException {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
        	Expense expense=optionalExpense.get();
        	Optional<Category> c=categoryRepository.findById(expense.getCategory());
        	if(c.isPresent()) {
        		Category category=c.get();
        		expense.setCategoryEntity(category);
        	}
        	return expense;
        }
        else {
        	throw new ExpenseNotFoundException("The entered id :"+id +" is not present");
        }
    }

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
            Expense expense = optionalExpense.get();

            Field[] fields = Expense.class.getDeclaredFields();

            for (Field field : fields) {
                try {
                    field.setAccessible(true);

                    if (field.getName().equals("id")) {
                        continue;
                    }

                    Object updatedValue = field.get(updatedExpense);

                    if (updatedValue != null) {
                        field.set(expense, updatedValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            return expenseRepository.save(expense);
        } else {
            throw new ExpenseNotFoundException("The entered id: " + id + " is not present");
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