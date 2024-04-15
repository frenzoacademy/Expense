package com.fz.ExpenseTracker.Account_Type;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountTypeService {
	@Autowired
	AccountTypeReporitory accountcategoryrepository;

	public Account_Type addAccountCategory(Account_Type accountCategory) {
		Account_Type ac = accountcategoryrepository.save(accountCategory);
		return ac;
	}

	public List<Account_Type> getAccountCategories() {
		List<Account_Type> acl = (List<Account_Type>) accountcategoryrepository.findAll();
		return acl;
	}

	public Account_Type getAccountCategoryById(int id) {
		Optional<Account_Type> acoc = accountcategoryrepository.findById(id);
		if (acoc.isPresent()) {
			Account_Type aco = acoc.get();
			return aco;
		} else {
			throw new AccountTypeNotFoundException("Given data is not found");
		}
	}

	public Account_Type updateAccountCategory(int id, Account_Type accountCategory) {
		Optional<Account_Type> acoc = accountcategoryrepository.findById(id);
		if (acoc.isPresent()) {
			Account_Type aco = acoc.get();
			if (accountCategory.getName() != null) {
				aco.setName(accountCategory.getName());
			}
			accountcategoryrepository.save(aco);
			return aco;
		} else {
			throw new AccountTypeNotFoundException("Given data is not foind");
		}
	}

	public void deleteAccountCategory(int id) throws AccountTypeNotFoundException {
		Optional<Account_Type> acoc = accountcategoryrepository.findById(id);
		if (acoc.isPresent()) {
			accountcategoryrepository.deleteById(id);
		}else {
			throw new AccountTypeNotFoundException  ("given data is not found");
		}

	}

}
