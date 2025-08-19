package com.wipro.travelagency.service;

import java.util.List;

import com.wipro.travelagency.entities.PaymentRequest;
import com.wipro.travelagency.entities.PaymentResponse;

public interface PaymentService {
	
	PaymentResponse makePayment(PaymentRequest request);
    PaymentResponse getPaymentByBookingId(Long bookingId);
    List<PaymentResponse> getAllPayments();
}
