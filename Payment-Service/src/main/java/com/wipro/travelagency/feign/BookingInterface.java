package com.wipro.travelagency.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.travelagency.entities.BookingResponse;

@FeignClient(name = "Booking-Service", path = "/api/v1/booking")
public interface BookingInterface {
	
	@GetMapping("/getBookingById/{id}")
    public BookingResponse getBookingById(@PathVariable Long id);
}
