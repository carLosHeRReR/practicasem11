package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

@Repository
public interface OwnerRepository 
	extends CrudRepository<Owner, Long> {

	// Fetch pets by name
	List<Owner> findByFirst_Name(String first_name);

	// Fetch pets by typeId
	List<Owner> findByLast_name(String last_name);

	// Fetch pets by ownerId
	List<Owner> findByAddress(String address);
	
	// Fetch pets by ownerId
	List<Owner> findByCity(String city);
	
	// Fetch pets by ownerId
	List<Owner> findByTelephone(String telephone);
	// Fetch pets by ownerId
}
