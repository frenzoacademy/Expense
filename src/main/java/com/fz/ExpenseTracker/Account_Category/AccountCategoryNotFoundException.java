package com.fz.ExpenseTracker.Account_Category;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountCategoryNotFoundException extends RuntimeException {

    public AccountCategoryNotFoundException(String message) {
        super(message);
    }

    public AccountCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}