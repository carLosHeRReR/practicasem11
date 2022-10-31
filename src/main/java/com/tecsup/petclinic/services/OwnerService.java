package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnertNotFoundException;

public interface OwnerService {

	/**
	 * 
	 * @param pet
	 * @return
	 */
	Owner create(Owner pet);

	/**
	 * 
	 * @param pet
	 * @return
	 */
	Owner update(Owner pet);

	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	void delete(Long id) throws OwnertNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(long id) throws OwnertNotFoundException;

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Owner> findByFirst_Name(String first_name);
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Owner> findByLast_name(String last_name);
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Owner> findByAddress(String address);
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Owner> findByCity(String city);
	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Owner> findByTelephone(String telephone);
	/**
	 * 
	 * @param name
	 * @return
	 */
	Iterable<Owner> findAll();
	/**
	 * 
	 * @param name
	 * @return
	 */
}