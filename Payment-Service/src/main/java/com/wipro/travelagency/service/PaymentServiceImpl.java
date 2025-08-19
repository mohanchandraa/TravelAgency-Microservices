package com.wipro.travelagency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.travelagency.entities.BookingResponse;
import com.wipro.travelagency.entities.Payment;
import com.wipro.travelagency.entities.PaymentRequest;
import com.wipro.travelagency.entities.PaymentResponse;
import com.wipro.travelagency.exception.BookingNotFoundException;
import com.wipro.travelagency.exception.PaymentNotFoundException;
import com.wipro.travelagency.feign.BookingInterface;
import com.wipro.travelagency.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingInterface bookingInterface;
    
    @Override
    public PaymentResponse makePayment(PaymentRequest request) {
        BookingResponse booking = bookingInterface.getBookingById(request.getBookingId());
        if (booking == null) {
            throw new BookingNotFoundException("Booking not found with ID: " + request.getBookingId());
        }

        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setMethod(request.getMethod());
        payment.setStatus("SUCCESS"); 

        payment = paymentRepository.save(payment);

        return mapToResponse(payment);
    }
    
    @Override
    public PaymentResponse getPaymentByBookingId(Long bookingId) {
        Payment payment = paymentRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found for booking ID: " + bookingId));
        return mapToResponse(payment);
    }
    
    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }
    
    private PaymentResponse mapToResponse(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(payment.getId());
        response.setBookingId(payment.getBookingId());
        response.setAmount(payment.getAmount());
        response.setMethod(payment.getMethod());
        response.setStatus(payment.getStatus());
        return response;
    }
    
}
