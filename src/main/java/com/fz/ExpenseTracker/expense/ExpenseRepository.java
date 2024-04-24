package com.fz.ExpenseTracker.expense;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fz.ExpenseTracker.category.Category;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

    Expense findByCategoryEntity(Category category);

	void save(ExpenseDTO expense);
    List<Expense> findAll();
    @Query("SELECT SUM(i.amount) FROM Expense i")
    Double sumAllExpenseAmounts();
}
