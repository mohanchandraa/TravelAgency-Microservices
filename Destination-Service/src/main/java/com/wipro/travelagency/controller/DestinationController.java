package com.wipro.travelagency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.wipro.travelagency.entities.Destination;
import com.wipro.travelagency.entities.DestinationResponse;
import com.wipro.travelagency.service.DestinationService;

@RestController
@RequestMapping("/api/v1/destination")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping("/addNewDestination")
    public Destination addNewDestination(@RequestBody Destination destination) {
        return destinationService.addNewDestination(destination);
    }

    @GetMapping("/getAllDestinationsPage")
    public Page<Destination> getAllDestinationsPage(Pageable pageable) {
        return destinationService.getAllDestinationsPage(pageable);
    }
    
    @GetMapping("/getDestinationById/{id}")
    public DestinationResponse getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }


    @DeleteMapping("/deleteDestinationById/{id}")
    public void deleteDestinationById(@PathVariable Long id) {
        destinationService.deleteDestinationById(id);
    }
}
