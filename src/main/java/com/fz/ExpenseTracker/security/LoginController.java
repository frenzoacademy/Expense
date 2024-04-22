package com.fz.ExpenseTracker.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fz.ExpenseTracker.users.Users;
import com.fz.ExpenseTracker.users.UsersRepository;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public Map<String, Object> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

            String email = authRequest.getEmail();
            Users user = getUserByEmail(email);

            System.out.println(authRequest.getEmail());
            if (authentication.isAuthenticated() && user != null) {
                String role = user.getRoleEntity().getRoles(); 

                String token = jwtService.generateToken(email, role);

                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("role", role);
                response.put("id", user.getId());

                return response;
            } else {
                throw new UsernameNotFoundException("Invalid user request!");
            }
        } catch (AuthenticationException ex) {
            throw new RuntimeException("Authentication failed: " + ex.getMessage());
        }
    }

    private Users getUserByEmail(String email) {
        Optional<Users> user = usersRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }

        throw new UsernameNotFoundException("User not found");
    }
}

