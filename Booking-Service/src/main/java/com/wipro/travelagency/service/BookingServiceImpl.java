package com.wipro.travelagency.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.travelagency.entities.*;
import com.wipro.travelagency.exception.BookingNotFoundException;
import com.wipro.travelagency.exception.PackageNotFoundException;
import com.wipro.travelagency.exception.UserNotFoundException;
import com.wipro.travelagency.feign.PackageInterface;
import com.wipro.travelagency.feign.UserInterface;
import com.wipro.travelagency.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PackageInterface packageInterface;

    @Autowired
    private UserInterface userInterface;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        UserResponse user = userInterface.getUserById(bookingRequest.getUserId());
        if (user == null) {
            throw new UserNotFoundException("User not found with id: " + bookingRequest.getUserId());
        }

        PackageResponse pkg = packageInterface.getPackageById(bookingRequest.getPackageId());
        if (pkg == null) {
            throw new PackageNotFoundException("Package not found with id: " + bookingRequest.getPackageId());
        }

        Booking booking = new Booking();
        booking.setUserId(bookingRequest.getUserId());
        booking.setPackageId(bookingRequest.getPackageId());
        booking.setUserName(user.getName());
        booking.setPackageName(pkg.getPackageName());
        booking.setBookingDate(LocalDate.now());
        booking.setStatus("CONFIRMED");

        Booking savedBooking = bookingRepository.save(booking);

        return mapToResponse(savedBooking);
    }

    @Override
    public BookingResponse getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with id: " + id));
        return mapToResponse(booking);
    }

    @Override
    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new BookingNotFoundException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }

    private BookingResponse mapToResponse(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.setBookingId(booking.getId());
        response.setUserName(booking.getUserName());
        response.setPackageName(booking.getPackageName());
        response.setBookingDate(booking.getBookingDate());
        response.setStatus(booking.getStatus());
        return response;
    }
}
