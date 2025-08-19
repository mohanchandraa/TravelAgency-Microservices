package com.wipro.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.travelagency.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
