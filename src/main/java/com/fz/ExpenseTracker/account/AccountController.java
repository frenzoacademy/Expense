package com.fz.ExpenseTracker.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accounts = accountService.getAllAccounts();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable int id) throws AccountNotFoundException {
		Account account = accountService.getAccountById(id);
		if (account != null) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF')")
	public ResponseEntity<Account> addAccount(@RequestBody AccountDTO account) {
		Account createdAccount = accountService.addAccount(account);
		return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account account) {
		Account updatedAccount = accountService.updateAccount(id, account);
		if (updatedAccount != null) {
			return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
		boolean deleted = accountService.deleteAccount(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
