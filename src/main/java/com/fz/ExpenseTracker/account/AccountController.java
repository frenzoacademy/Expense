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

	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accounts = accountService.getAllAccounts();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable int id) throws AccountNotFoundException {
		Account account = accountService.getAccountById(id);
		if (account != null) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF')")
	@PostMapping
	public ResponseEntity<Account> addAccount(@RequestBody AccountDTO account) {
		Account createdAccount = accountService.addAccount(account);
		return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account account) {
		Account updatedAccount = accountService.updateAccount(id, account);
		if (updatedAccount != null) {
			return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@PreAuthorize("hasRole('ADMIN')")
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
	
	
	
	
	/*@Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(@AuthenticationPrincipal Jwt jwt) {
        authorizeAdmin(jwt);
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id, @AuthenticationPrincipal Jwt jwt) throws AccountNotFoundException {
        authorizeAdmin(jwt);
        Account account = accountService.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private void authorizeAdmin(Jwt jwt) {
        Collection<? extends GrantedAuthority> authorities = ((Authentication) jwt).getAuthorities();
        boolean isAdmin = authorities.stream()
                                    .map(GrantedAuthority::getAuthority)
                                    .anyMatch("ROLE_ADMIN"::equals);
        if (!isAdmin) {
            throw new AccessDeniedException("Unauthorized");
        }
    }

    private void authorizeAdminOrStaff(Jwt jwt) {
        Collection<? extends GrantedAuthority> authorities = ((Authentication) jwt).getAuthorities();
        boolean isAdminOrStaff = authorities.stream()
                                           .map(GrantedAuthority::getAuthority)
                                           .anyMatch(role -> "ROLE_ADMIN".equals(role) || "ROLE_STAFF".equals(role));
        if (!isAdminOrStaff) {
            throw new AccessDeniedException("Unauthorized");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id, @AuthenticationPrincipal Jwt jwt) {
        authorizeAdmin(jwt);
        boolean deleted = accountService.deleteAccount(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private void authorizeAdmin(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean isAdmin = authorities.stream()
                                    .map(GrantedAuthority::getAuthority)
                                    .anyMatch("ROLE_ADMIN"::equals);
        if (!isAdmin) {
            throw new AccessDeniedException("Unauthorized");
        }
    }

    private void authorizeAdminOrStaff(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean isAdminOrStaff = authorities.stream()
                                           .map(GrantedAuthority::getAuthority)
                                           .anyMatch(role -> "ROLE_ADMIN".equals(role) || "ROLE_STAFF".equals(role));
        if (!isAdminOrStaff) {
            throw new AccessDeniedException("Unauthorized");
        }
    }}*/
