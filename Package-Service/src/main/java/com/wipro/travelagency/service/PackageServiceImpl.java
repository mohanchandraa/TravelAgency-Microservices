package com.wipro.travelagency.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.travelagency.entities.DestinationResponse;
import com.wipro.travelagency.entities.PackageEntity;
import com.wipro.travelagency.entities.PackageResponse;
import com.wipro.travelagency.exception.PackageNotFoundException;
import com.wipro.travelagency.feign.DestinationInterface;
import com.wipro.travelagency.repository.PackageRepository;

import feign.FeignException;

@Service
public class PackageServiceImpl implements PackageService {

	
	@Autowired
	private PackageRepository packageRepository;
	
	@Autowired
	private DestinationInterface destinationInterface;
	
	@Override
	public PackageEntity addNewPackage(PackageEntity packageEntity) {
		
		for (Long destId : packageEntity.getDestinationIds()) {
            try {
                destinationInterface.getDestinationById(destId);
            } catch (FeignException.NotFound e) {
                throw new IllegalArgumentException("Destination ID " + destId + " does not exist.");
            }
        }
        return packageRepository.save(packageEntity);
	}
	

	@Override
	public Page<PackageEntity> getAllPackages(Pageable pageable) {
		return packageRepository.findAll(pageable) ;
	}

	@Override
    public void deletePackageById(Long id) {
        if (!packageRepository.existsById(id)) {
            throw new PackageNotFoundException("Package not found with id: " + id);
        }
        packageRepository.deleteById(id);
    }
	
	
	@Override
    public PackageResponse getPackageWithDestination(Long id) {
		PackageEntity pkg = packageRepository.findById(id)
			    .orElseThrow(() -> new PackageNotFoundException("Package not found with id: " + id));


        PackageResponse response = new PackageResponse();
        response.setId(pkg.getId());
        response.setPackageName(pkg.getPackageName());
        response.setDescription(pkg.getDescription());
        response.setDurationDays(pkg.getDurationDays());
        response.setTotalPrice(pkg.getTotalPrice());

        List<DestinationResponse> destinations = new ArrayList<>();
        for (Long destId : pkg.getDestinationIds()) {
            DestinationResponse destination = destinationInterface.getDestinationById(destId);
            destinations.add(destination);
        }
        response.setDestinations(destinations);

        return response;
    }


	@Override
	public PackageResponse getPackageById(Long id) {
		
		PackageEntity entity =  packageRepository.findById(id).orElseThrow(() -> new PackageNotFoundException("Package not found with id: " + id));
		
		PackageResponse response = new PackageResponse();
		response.setId(entity.getId());
		response.setPackageName(entity.getPackageName());
        response.setDescription(entity.getDescription());
        response.setTotalPrice(entity.getTotalPrice());
        response.setDurationDays(entity.getDurationDays());
        return response;
	}
	
	
	
}
