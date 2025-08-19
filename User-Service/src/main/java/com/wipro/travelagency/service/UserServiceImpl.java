package com.wipro.travelagency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.travelagency.entities.User;
import com.wipro.travelagency.entities.UserResponse;
import com.wipro.travelagency.exception.UserNotFoundException;
import com.wipro.travelagency.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addNewUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Page<User> getAllUsersPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	
	@Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setGender(user.getGender());
        response.setPhone(user.getPhone());
        response.setEmail(user.getEmail());
        response.setAge(user.getAge());
        
        return response;
    }

	@Override
	public void deleteUserById(Long id) {
		if (!userRepository.existsById(id)) {
	        throw new UserNotFoundException("User with ID " + id + " not found");
	    }
	    userRepository.deleteById(id);
	}
	
}
