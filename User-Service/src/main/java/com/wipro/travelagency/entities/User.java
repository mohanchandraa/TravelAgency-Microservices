package com.wipro.travelagency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="user_table")
@Data
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message = "Name is required field!")
	private String name;
	
	@Email(message = "Email is required field!")
	private String email;
	
	@NotBlank(message = "Phone is required field!")
	private Long phone;
	private String gender;
	
	@NotNull(message = "Age is required field!")
	private Integer age;
}
