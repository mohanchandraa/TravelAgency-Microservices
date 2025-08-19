package com.wipro.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.travelagency.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
