package com.fz.ExpenseTracker.Account_Type;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountTypeNotFoundException extends RuntimeException {

    public AccountTypeNotFoundException(String message) {
        super(message);
    }

    public AccountTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}