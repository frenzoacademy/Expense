package com.fz.ExpenseTracker.income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer>{
	@Query("SELECT SUM(i.amount) FROM Income i")
    Double sumAllIncomeAmounts();
}
