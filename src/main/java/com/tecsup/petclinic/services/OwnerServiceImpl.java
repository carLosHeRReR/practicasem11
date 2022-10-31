package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnertNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;


@Service
public class OwnerServiceImpl implements OwnerService {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

	@Autowired
	OwnerRepository ownerRepository;

	/**
	 * 
	 * @param pet
	 * @return
	 */
	@Override
	public Owner create(Owner pet) {
		return ownerRepository.save(pet);
	}

	/**
	 * 
	 * @param pet
	 * @return
	 */
	@Override
	public Owner update(Owner pet) {
		return ownerRepository.save(pet);
	}


	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	@Override
	public void delete(Long id) throws OwnertNotFoundException{

		Owner pet = findById(id);
		ownerRepository.delete(pet);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Owner findById(long id) throws OwnertNotFoundException {

		Optional<Owner> pet = OwnerRepository.findById(id);

		if ( !pet.isPresent())
			throw new OwnertNotFoundException("Record not found...!");
			
		return pet.get();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public List<Owner> findByFirst_Name(String first_name) {

		List<Owner> owners = OwnerRepository.findByFirst_Name(first_name);

		owners.stream().forEach(pet -> logger.info("" + pet));

		return owners;
	}

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	@Override
	public List<Owner> findByLast_Name(String last_name) {

		List<Owner> owners = OwnerRepository.findByLast_Name(last_name);

		owners.stream().forEach(pet -> logger.info("" + pet));

		return owners;
	}

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	@Override
	public List<Owner> findByAddress(String address) {

		List<Owner> owners = OwnerRepository.findByAddress(address);

		owners.stream().forEach(pet -> logger.info("" + pet));

		return owners;
	}
	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	@Override
	public List<Owner> findByCity(String city) {

		List<Owner> owners = OwnerRepository.findByCity(city);

		owners.stream().forEach(pet -> logger.info("" + pet));

		return owners;
	}
	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	@Override
	public List<Owner> findByTelephone(String telephone) {

		List<Owner> owners = OwnerRepository.findByTelephone(telephone);

		owners.stream().forEach(pet -> logger.info("" + pet));

		return owners;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Owner> findAll() {
		
		// TODO Auto-generated 
		return OwnerRepository.findAll();
	
	}
}