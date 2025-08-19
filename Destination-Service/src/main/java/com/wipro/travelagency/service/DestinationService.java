package com.wipro.travelagency.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.travelagency.entities.Destination;
import com.wipro.travelagency.entities.DestinationResponse;

public interface DestinationService {
	Destination addNewDestination(Destination destination);
    Page<Destination> getAllDestinationsPage(Pageable pageable);
    void deleteDestinationById(Long id);
	DestinationResponse getDestinationById(Long id);
}
