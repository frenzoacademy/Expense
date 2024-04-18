package com.fz.ExpenseTracker.security;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.stereotype.Component;

import com.fz.ExpenseTracker.users.Users;

import java.util.Optional;

	@Component
	public class UserInfoUserDetailsService implements UserDetailsService {

	    @Autowired
	    private UserInfoRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Optional<Users> userInfo = repository.findByEmail(email);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));

	    }
	}

