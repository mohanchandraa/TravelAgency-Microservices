package com.wipro.travelagency.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.travelagency.entities.PackageEntity;
import com.wipro.travelagency.entities.PackageResponse;

public interface PackageService {

	PackageEntity addNewPackage(PackageEntity packageEntity);

	Page<PackageEntity> getAllPackages(Pageable pageable);

	void deletePackageById(Long id);
	
    PackageResponse getPackageWithDestination(Long id);

	PackageResponse getPackageById(Long id);
}
