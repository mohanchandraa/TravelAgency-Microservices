package com.wipro.travelagency.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.travelagency.entities.PackageResponse;

@FeignClient(name="Package-Service",path="/api/v1/package")
public interface PackageInterface {
	
	@GetMapping("/getPackageById/{id}")
    public PackageResponse getPackageById(@PathVariable Long id);
}
