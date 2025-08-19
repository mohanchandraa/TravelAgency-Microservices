package com.wipro.travelagency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.travelagency.entities.PackageEntity;
import com.wipro.travelagency.entities.PackageResponse;
import com.wipro.travelagency.service.PackageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/package")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@PostMapping("/addNewPackage")
    public PackageEntity addNewPackage(@Valid @RequestBody PackageEntity packageEntity) {
        return packageService.addNewPackage(packageEntity);
    }
	
	@GetMapping("/getAllPackagesPage")
    public Page<PackageEntity> getAllPackages(Pageable pageable) {
        return packageService.getAllPackages(pageable);
    }
	
	@GetMapping("/getPackageWithDestination/{id}")
    public PackageResponse getPackageWithDestination(@PathVariable Long id) {
        return packageService.getPackageWithDestination(id);
    }

    @DeleteMapping("/deletePackageById/{id}")
    public void deletePackageById(@PathVariable Long id) {
        packageService.deletePackageById(id);
    }
	
    @GetMapping("/getPackageById/{id}")
    public PackageResponse getPackageById(@PathVariable Long id) {
    	return packageService.getPackageById(id);
    }
	
	
	
	
	
}
