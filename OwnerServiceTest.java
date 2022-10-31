package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;

import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);
	
	@Autowired
   	private OwnerService ownerService;

	/**
	 * 
	 */
	
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String FIRST_NAME = "Diego";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertEquals(FIRST_NAME, owner.getFirst_name());

	}
	
	@Test
	public void testCreateOwner() {
		
		String FIRST_NAME = "Diego";
		String LAST_NAME = "Porras";
		String ADDRESS= "402 Martinete";
		String CITY= "Lima";
		int TELEPHONE=123456789;
		
		Owner owner = new Owner(1, FIRST_NAME,LAST_NAME,ADDRESS,CITY,123456789);
		
		Owner ownerCreated = ownerService.create(owner);
		
		logger.info("OWNER CREATED :" + ownerCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(ownerCreated.getId()      , notNullValue());
		assertThat(ownerCreated.getFirst_name()    , is(FIRST_NAME));
		assertThat(ownerCreated.getLast_name() , is(LAST_NAME));
		assertThat(ownerCreated.getAddress()  , is(ADDRESS));
		assertThat(ownerCreated.getCity()  , is(CITY));
		assertThat(ownerCreated.getTelephone()  , is(TELEPHONE));

	}
	public void testDeleteOwner() {

		String FIRST_NAME = "Diego";
		String LAST_NAME = "Porras";
		String ADDRESS= "402 Martinete";
		String CITY= "Lima";
		int TELEPHONE= 123456789;

		Owner owner = new Owner(1,FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			ownerService.findById(owner.getId());
			fail("Owner id = " + owner.getId() + " has not delete");
		} catch (OwnerNotFoundException e) {
		} 				

	}
		
	}

