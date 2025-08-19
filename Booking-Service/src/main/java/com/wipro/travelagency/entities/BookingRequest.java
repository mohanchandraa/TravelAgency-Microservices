package com.wipro.travelagency.entities;

import lombok.Data;

@Data
public class BookingRequest {
	private Long userId;
    private Long packageId;
}
