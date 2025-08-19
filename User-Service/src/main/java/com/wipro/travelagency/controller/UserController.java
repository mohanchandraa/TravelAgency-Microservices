package com.wipro.travelagency.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.travelagency.entities.User;
import com.wipro.travelagency.entities.UserResponse;
import com.wipro.travelagency.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addNewUser")
	public User addNewUser(@Valid @RequestBody User user) {
		return userService.addNewUser(user);
	}
	
	@GetMapping("/getAllUsersPage")
	public Page<User> getAllUsersPage(Pageable pageable){
		return userService.getAllUsersPage(pageable);
	}
	
	@GetMapping("/getUserById/{id}")
	public UserResponse getUserById(@PathVariable Long id) {
	    return userService.getUserById(id);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}
}
