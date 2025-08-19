package com.wipro.travelagency.entities;

import java.util.List;

import lombok.Data;

@Data
public class PackageResponse {
	
	private Long id;
    private String packageName;
    private String description;
    private Integer durationDays;
    private Double totalPrice;
    
    private List<DestinationResponse> destinations;
}
