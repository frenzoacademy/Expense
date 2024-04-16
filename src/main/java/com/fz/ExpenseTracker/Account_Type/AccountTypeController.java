package com.fz.ExpenseTracker.Account_Type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account_type")
public class AccountTypeController {
	
	@Autowired
    AccountTypeService accountCategoryService;

    @PostMapping
    public ResponseEntity<Account_Type> addAccountCategory(@RequestBody Account_Type accountCategory) {
        accountCategoryService.addAccountCategory(accountCategory);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account_Type>> getAccountCategories() {
        List<Account_Type> accountCategories = accountCategoryService.getAccountCategories();
        return new ResponseEntity<>(accountCategories, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account_Type> getAccountCategoryById(@PathVariable("id") int id) {
        Account_Type accountCategory = accountCategoryService.getAccountCategoryById(id);
        return new ResponseEntity<>(accountCategory, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account_Type> updateAccountCategory(@PathVariable int id, @RequestBody Account_Type accountCategory) {
        Account_Type updatedAccountCategory = accountCategoryService.updateAccountCategory(id, accountCategory);
        return new ResponseEntity<>(updatedAccountCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAccountCategory(@PathVariable int id) throws AccountTypeNotFoundException {
        accountCategoryService.deleteAccountCategory(id);
        return HttpStatus.OK;
    }
}
