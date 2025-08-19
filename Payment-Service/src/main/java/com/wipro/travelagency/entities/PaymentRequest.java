package com.wipro.travelagency.entities;

import lombok.Data;

@Data
public class PaymentRequest { 
	
    private Long bookingId;
    private Double amount;
    private String method;
}
