package com.wipro.travelagency.entities;

import lombok.Data;

@Data
public class PaymentResponse {
	
    private Long paymentId;
    private Long bookingId;
    private Double amount;
    private String method;
    private String status;
}