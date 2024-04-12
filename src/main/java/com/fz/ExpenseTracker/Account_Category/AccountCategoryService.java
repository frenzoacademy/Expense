package com.fz.ExpenseTracker.Account_Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fz.expenses.ExpenseTracker.category.CategoryNotFoundException;

@Service
public class AccountCategoryService {
	@Autowired
	AccountCategoryReporitory accountcategoryrepository;

	public Account_Category addAccountCategory(Account_Category accountCategory) {
		Account_Category ac = accountcategoryrepository.save(accountCategory);
		return ac;
	}

	public List<Account_Category> getAccountCategories() {
		List<Account_Category> acl = (List<Account_Category>) accountcategoryrepository.findAll();
		return acl;
	}

	public Account_Category getAccountCategoryById(int id) {
		Optional<Account_Category> acoc = accountcategoryrepository.findById(id);
		if (acoc.isPresent()) {
			Account_Category aco = acoc.get();
			return aco;
		} else {
			throw new AccountCategoryNotFoundException("Given data is not found");
		}
	}

	public Account_Category updateAccountCategory(int id, Account_Category accountCategory) {
		Optional<Account_Category> acoc = accountcategoryrepository.findById(accountCategory.getId());
		if (acoc.isPresent()) {
			Account_Category aco = acoc.get();
			if (accountCategory.getName() != null) {
				aco.setName(accountCategory.getName());
			}
			accountcategoryrepository.save(aco);
			return aco;
		} else {
			throw new AccountCategoryNotFoundException("Given data is not foind");
		}
	}

	public void deleteAccountCategory(int id) throws AccountCategoryNotFoundException {
		Optional<Account_Category> acoc = accountcategoryrepository.findById(id);
		if (acoc.isPresent()) {
			accountcategoryrepository.deleteById(id);
		}else {
			throw new AccountCategoryNotFoundException  ("given data is not found");
		}

	}

}
