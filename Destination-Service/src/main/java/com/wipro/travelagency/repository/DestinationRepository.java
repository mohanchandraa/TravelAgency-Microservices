package com.wipro.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.travelagency.entities.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long>{

}
