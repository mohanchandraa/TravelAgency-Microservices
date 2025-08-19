package com.wipro.travelagency.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="package_table")
@Data
public class PackageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message ="Package name should be included!")
	private String packageName;
	
	@NotBlank(message ="Package description should be included!")
	private String description;
	
	@NotNull(message ="Package duration is a required field!")
	private Integer durationDays;
	
	@NotNull(message ="Price should be mentioned beforehand!")
	private Double totalPrice;
	
	@ElementCollection
	private List<Long> destinationIds;
}
