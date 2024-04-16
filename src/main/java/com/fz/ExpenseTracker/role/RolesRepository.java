package com.fz.ExpenseTracker.role;

import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Integer>{


	Roles findByRoles(String role);

}
