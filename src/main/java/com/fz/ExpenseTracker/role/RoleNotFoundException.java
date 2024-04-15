package com.fz.ExpenseTracker.role;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
        super(message);
    }
}
