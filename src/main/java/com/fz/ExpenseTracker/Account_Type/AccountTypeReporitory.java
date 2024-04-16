package com.fz.ExpenseTracker.Account_Type;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AccountTypeReporitory extends CrudRepository<Account_Type, Integer> {

	Optional<Account_Type> findByName(String account_type);

}
