package com.fz.ExpenseTracker.Account_Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account-categories")
public class AccountCategoryController {
	
	@Autowired
    AccountCategoryService accountCategoryService;

    @PostMapping
    public ResponseEntity<Account_Category> addAccountCategory(@RequestBody Account_Category accountCategory) {
        accountCategoryService.addAccountCategory(accountCategory);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account_Category>> getAccountCategories() {
        List<Account_Category> accountCategories = accountCategoryService.getAccountCategories();
        return new ResponseEntity<>(accountCategories, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account_Category> getAccountCategoryById(@PathVariable("id") int id) {
        Account_Category accountCategory = accountCategoryService.getAccountCategoryById(id);
        return new ResponseEntity<>(accountCategory, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account_Category> updateAccountCategory(@PathVariable int id, @RequestBody Account_Category accountCategory) {
        Account_Category updatedAccountCategory = accountCategoryService.updateAccountCategory(id, accountCategory);
        return new ResponseEntity<>(updatedAccountCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAccountCategory(@PathVariable int id) throws AccountCategoryNotFoundException {
        accountCategoryService.deleteAccountCategory(id);
        return HttpStatus.OK;
    }
}
