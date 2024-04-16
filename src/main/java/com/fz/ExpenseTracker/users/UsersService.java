package com.fz.ExpenseTracker.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	private UsersRepository userRepository;

	public List<Users> getAllUsers() {
		return (List<Users>) userRepository.findAll();
	}

	public Users getUserById(int id) throws UserNotFoundException {
		Optional<Users> optionalUser = userRepository.findById(id);
		return optionalUser.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
	}

	public void createUser(Users user) {
		userRepository.save(user);
	}

	public Users updateUser(int id, Users updatedUser) throws UserNotFoundException {
		Optional<Users> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			updatedUser.setId(id);
			return userRepository.save(updatedUser);
		} else {
			throw new UserNotFoundException("User with ID " + id + " not found");
		}
	}

	public boolean deleteUser(int id) {
		Optional<Users> optionalUser = userRepository.findById(id);
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
