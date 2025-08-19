package com.wipro.travelagency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.travelagency.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	Optional<Payment> findByBookingId(Long bookingId);
}
