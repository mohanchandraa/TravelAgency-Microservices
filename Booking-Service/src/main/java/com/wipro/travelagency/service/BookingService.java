package com.wipro.travelagency.service;

import java.util.List;

import com.wipro.travelagency.entities.BookingRequest;
import com.wipro.travelagency.entities.BookingResponse;

public interface BookingService {

	BookingResponse createBooking(BookingRequest bookingRequest);

	BookingResponse getBookingById(Long id);

	List<BookingResponse> getAllBookings();

	void deleteBooking(Long id);


}
