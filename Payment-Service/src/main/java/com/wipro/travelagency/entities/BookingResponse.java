package com.wipro.travelagency.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingResponse {
	
	private Long bookingId;
    private String userName;
    private String packageName;
    private LocalDate bookingDate;
    private String status;
}
