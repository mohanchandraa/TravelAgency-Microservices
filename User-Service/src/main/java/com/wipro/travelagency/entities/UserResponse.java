package com.wipro.travelagency.entities;

import lombok.Data;

@Data
public class UserResponse {
	
	private Long id;
	private String name;
	private String email;
	private Long phone;
	private String gender;
	private Integer age;
}
