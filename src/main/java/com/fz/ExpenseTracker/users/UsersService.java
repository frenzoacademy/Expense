package com.fz.ExpenseTracker.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fz.ExpenseTracker.role.Roles;
import com.fz.ExpenseTracker.role.RolesRepository;

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

	@Autowired
	RolesRepository rolesRepository;
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	 public void createUser(UsersDTO userDto) {
	        Users user = new Users();
	        user.setFirstName(userDto.getFirstName());
	        user.setLastName(userDto.getLastName());
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
	        user.setMobile(userDto.getMobile());
	        user.setEmail(userDto.getEmail());
	        Roles role=rolesRepository.findByRoles(userDto.getRole());
	        user.setRoleEntity(role);
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
