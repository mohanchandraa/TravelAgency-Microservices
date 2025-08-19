package com.wipro.travelagency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.travelagency.entities.BookingRequest;
import com.wipro.travelagency.entities.BookingResponse;
import com.wipro.travelagency.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/createBooking")
    public BookingResponse createBooking(@Valid @RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }

    @GetMapping("/getBookingById/{id}")
    public BookingResponse getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/getAllBookings")
    public List<BookingResponse> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("deleteBookingById/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
	
}
