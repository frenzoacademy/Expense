package com.fz.ExpenseTracker.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fz.ExpenseTracker.Account_Type.AccountTypeReporitory;
import com.fz.ExpenseTracker.Account_Type.Account_Type;
import com.fz.ExpenseTracker.category.Category;
import com.fz.ExpenseTracker.service.Services;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<Account> listOfAccounts = new ArrayList<>();
        for (Account acc : accounts) {
            Account a = new Account();
            a.setId(acc.getId());
            a.setName(acc.getName());
            a.setUpi_id(acc.getUpi_id());
            a.setAccount_number(acc.getAccount_number());
            a.setAmount(acc.getAmount());
//            Optional<Account_Type> accountType = accountTypeRepo.findById(acc.getAccountEntity().getId());
//            if (accountType.isPresent()) {
//            	Account_Type type = accountType.get();
//                a.setAccountEntity(type);
//            }
            a.setAccountEntity(acc.getAccountEntity());
            listOfAccounts.add(a);
        }
        return listOfAccounts;
    }

    public Account getAccountById(int id) throws AccountNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
//            Optional<Account_Type> accountType = accountTypeRepo.findById(account.getAccountType().getId());
//            if (accountType.isPresent()) {
//            	Account_Type type = accountType.get();
//                account.setAccountEntity(type);
//            }
            return account;
        } else {
            throw new AccountNotFoundException("The entered id :" + id + " is not present");
        }
    }
	@Autowired
	AccountTypeReporitory accountTypeRepo;
	
	public Account addAccount(AccountDTO account) {
	    Optional<Account_Type> accountType =accountTypeRepo.findByName(account.getAccount_type());
	    Account acc=new Account();
	    if(accountType.isPresent()) {
	    	Account_Type a=accountType.get();
	    	acc.setAccountEntity(a);
	    }
	    acc.setAccount_number(account.getAccount_number());
	    acc.setAmount(account.getAmount());
	    acc.setName(account.getName());
	    acc.setUpi_id(account.getUpi_id());
	    return accountRepository.save(acc);
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
