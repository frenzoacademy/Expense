package com.fz.ExpenseTracker.dashboard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fz.ExpenseTracker.Account_Type.AccountTypeRepository;
import com.fz.ExpenseTracker.Account_Type.Account_Type;
import com.fz.ExpenseTracker.account.AccountRepository;
import com.fz.ExpenseTracker.account.AccountService;
import com.fz.ExpenseTracker.expense.ExpenseRepository;
import com.fz.ExpenseTracker.expense.ExpenseService;
import com.fz.ExpenseTracker.income.IncomeRepository;
import com.fz.ExpenseTracker.income.IncomeService;

@RestController
public class DashboardController {

	@Autowired
	private IncomeRepository incomeRepository;

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private AccountRepository accountRepository;

	
	@Autowired
	private AccountTypeRepository accountTypeRepository;

	@GetMapping("/dashboard")
	public DashboardData getDashboardData() {

		double overallIncomeAmount = incomeRepository.sumAllIncomeAmounts();

		double overallExpenseAmount = expenseRepository.sumAllExpenseAmounts();

		double totalAmountInAccount = accountRepository.sumAllAccountAmounts();

		List<Object[]> accountTypeBalances = accountRepository.sumAmountByAccountType();
	    Map<String, Double> accountTypeBalancesMap = new HashMap<>();
	    
	    for (Object[] result : accountTypeBalances) {
	        String accountTypeName = (String) result[0];
	        Number sumAmount = (Number) result[1];
	        accountTypeBalancesMap.put(accountTypeName, sumAmount.doubleValue());
	    }
	    
//		List<Object[]> accountTypeBalances = accountRepository.sumAmountByAccountType();
        return new DashboardData(overallIncomeAmount, overallExpenseAmount, totalAmountInAccount, accountTypeBalancesMap);
	}

}
