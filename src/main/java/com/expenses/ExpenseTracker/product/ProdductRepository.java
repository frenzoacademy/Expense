package com.expenses.ExpenseTracker.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdductRepository  extends CrudRepository<Product, Integer>{

}
