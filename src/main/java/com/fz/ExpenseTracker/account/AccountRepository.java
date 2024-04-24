package com.fz.ExpenseTracker.account;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	@Query("SELECT SUM(i.amount) FROM Account i")
    Double sumAllAccountAmounts();
    
	@Query("SELECT ac.name, SUM(a.amount) FROM Account a INNER JOIN a.accountEntity ac GROUP BY a.accountEntity")
	List<Object[]>  sumAmountByAccountType();

}
