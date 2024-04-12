package com.fz.ExpenseTracker.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account getAccountById(int id) {
		Optional<Account> optionalAccount = accountRepository.findById(id);
		return optionalAccount.orElse(null);
	}

	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account updateAccount(int id, Account updatedAccount) {
		Optional<Account> optionalAccount = accountRepository.findById(id);
		if (optionalAccount.isPresent()) {
			updatedAccount.setId(id);
			return accountRepository.save(updatedAccount);
		} else {
			return null;
		}
	}

	public boolean deleteAccount(int id) {
		Optional<Account> optionalAccount = accountRepository.findById(id);
		if (optionalAccount.isPresent()) {
			accountRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
