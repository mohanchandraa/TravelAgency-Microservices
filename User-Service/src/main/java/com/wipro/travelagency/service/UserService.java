package com.wipro.travelagency.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.travelagency.entities.User;
import com.wipro.travelagency.entities.UserResponse;

public interface UserService {

	User addNewUser(User user);

	Page<User> getAllUsersPage(Pageable pageable);

	void deleteUserById(Long id);

	UserResponse getUserById(Long id);

}
