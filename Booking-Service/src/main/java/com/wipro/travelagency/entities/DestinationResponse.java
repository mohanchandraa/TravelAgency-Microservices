package com.wipro.travelagency.entities;

import lombok.Data;

@Data
public class DestinationResponse {
	private Long id;
    private String name;
    private String country;
    private Double pricePerDay;
    private String description;
}
