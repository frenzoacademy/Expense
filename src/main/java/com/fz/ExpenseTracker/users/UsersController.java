package com.fz.ExpenseTracker.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	public UsersService userservice;

	@Autowired
	public UsersRepository userrepository;

	@PostMapping
    public ResponseEntity<String> createUser(@RequestBody UsersDTO userDto) {
		userservice.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created Your Account");
    }

//	@GetMapping
//	public String loginUsers() {
//		return "Login Successfully";
//	}

	@PutMapping("/{id}")
	public ResponseEntity<Users> updateUserDetails(@RequestBody Users users, @PathVariable int id) {
		userservice.updateUser(id, users);
		return new ResponseEntity<Users>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteUsers(@PathVariable int id) {
		userservice.deleteUser(id);
		return HttpStatus.OK;
	}

//	@PostMapping("/forgot-password")
//	public String forgotPassword(@RequestParam String email) {
//
//		String response = userservice.forgotPassword(email);
//
//		if (!response.startsWith("Invalid")) {
//			response = "http://localhost:8080/reset-password?token=" + response;
//		}
//		return response;
//	}
//
//	@PutMapping("/reset-password")
//	public String resetPassword(@RequestParam String token, @RequestParam String password) {
//
//		return userservice.resetPassword(token, password);
//	}
}
