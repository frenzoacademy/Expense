package com.fz.ExpenseTracker.expense;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fz.ExpenseTracker.category.Category;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

	Expense findByCategory(Category category);

	void save(ExpenseDto expense);
    List<Expense> findAll();

}
