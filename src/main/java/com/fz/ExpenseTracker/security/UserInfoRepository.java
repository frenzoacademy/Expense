package com.fz.ExpenseTracker.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fz.ExpenseTracker.users.Users;


import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String email);

}
