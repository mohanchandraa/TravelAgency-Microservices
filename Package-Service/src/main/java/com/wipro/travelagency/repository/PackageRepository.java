package com.wipro.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.travelagency.entities.PackageEntity;

@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, Long> {

}
