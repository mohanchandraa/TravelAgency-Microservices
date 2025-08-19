package com.wipro.travelagency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.wipro.travelagency.entities.Destination;
import com.wipro.travelagency.entities.DestinationResponse;
import com.wipro.travelagency.exception.DestinationNotFoundException;
import com.wipro.travelagency.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Destination addNewDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Page<Destination> getAllDestinationsPage(Pageable pageable) {
        return destinationRepository.findAll(pageable);
    }
    
    @Override
    public DestinationResponse getDestinationById(Long id) {
        Destination destination = destinationRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException("Destination not found with id: " + id));

        DestinationResponse response = new DestinationResponse();
        response.setId(destination.getId());
        response.setName(destination.getName());
        response.setCountry(destination.getCountry());
        response.setPricePerDay(destination.getPricePerDay());
        response.setDescription(destination.getDescription());
        return response;
    }

    @Override
    public void deleteDestinationById(Long id) {
    	
    	if (!destinationRepository.existsById(id)) {
	        throw new DestinationNotFoundException("Destination with ID " + id + " not found");
	    }
	    destinationRepository.deleteById(id);
    	
    }
    
    
}
