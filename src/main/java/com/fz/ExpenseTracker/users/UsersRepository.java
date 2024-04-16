package com.fz.ExpenseTracker.users;


import java.text.Normalizer.Form;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {


}
