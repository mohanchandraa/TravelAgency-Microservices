package com.wipro.travelagency.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.travelagency.entities.DestinationResponse;

@FeignClient(name="Destination-Service",path = "/api/v1/destination")
public interface DestinationInterface {

	@GetMapping("/getDestinationById/{id}")
    DestinationResponse getDestinationById(@PathVariable Long id);
}
