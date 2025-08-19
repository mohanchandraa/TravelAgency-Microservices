package com.wipro.travelagency.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.travelagency.entities.UserResponse;

@FeignClient(name="User-Service",path="/api/v1/user")
public interface UserInterface {
	
	@GetMapping("/getUserById/{id}")
	public UserResponse getUserById(@PathVariable Long id);
}
