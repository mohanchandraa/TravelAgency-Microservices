package com.wipro.travelagency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "destination_table")
@Data
public class Destination {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "Destination name is required field!")
    private String name;  
	
	@NotBlank(message = "Country is required field!")
    private String country;     
	
	@NotNull(message="Price is a required field!")
    private Double pricePerDay; 
    private String description;
}
