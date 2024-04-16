package com.fz.ExpenseTracker.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	private UsersRepository userRepository;

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public User getUserById(int id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
	}

	public void createUser(User user) {
		userRepository.save(user);
	}

	public User updateUser(int id, User updatedUser) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			updatedUser.setId(id);
			return userRepository.save(updatedUser);
		} else {
			throw new UserNotFoundException("User with ID " + id + " not found");
		}
	}

	public boolean deleteUser(int id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
