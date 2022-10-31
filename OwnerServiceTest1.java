package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;

@SpringBootTest
public class OwnerServiceTest1 {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest1.class);

	@Autowired
   	private OwnerService ownerService;

	/**
	 * 
	 */
	
	
	/*@Test
	 * public void testFindOwnerById() {

		long ID = 1;
		String NAME = "George";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertThat(owner.getName(), is(NAME));

	}
	*/
	@Test
	public void testUpdateOwner() {

		String FIRST_NAME = "George";
		String LAST_NAME = "Franklin";
		String ADDRESS = "110 W. Liberty St.";
		String CITY = "Madison";
		String TELEPHONE = "6085551023";

		String UP_FIRST_NAME = "George2";
		String UP_LAST_NAME = "Franklin2";
		String UP_ADDRESS = "La Molina";
		String UP_CITY = "Lima";
		String UP_TELEPHONE = "956326598";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS,CITY,TELEPHONE);

		// Create record
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		logger.info(">>" + ownerCreated);


		// Prepare data for update
		ownerCreated.setFirst_name(UP_FIRST_NAME);
		ownerCreated.setLast_name(UP_LAST_NAME);
		ownerCreated.setAddress(UP_ADDRESS);
		ownerCreated.setCity(UP_CITY);
		ownerCreated.setTelephone(UP_TELEPHONE);


		// Execute update
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);

		//        ACTUAL       EXPECTED
		assertThat(upgradeOwner.getFirst_name(), is(UP_FIRST_NAME));
		assertThat(upgradeOwner.getLast_name(), is(UP_LAST_NAME));
		assertThat(upgradeOwner.getAddress(), is(UP_ADDRESS));
		assertThat(upgradeOwner.getCity(), is(UP_CITY));
		assertThat(upgradeOwner.getTelephone(), is(UP_TELEPHONE));
	}

}
