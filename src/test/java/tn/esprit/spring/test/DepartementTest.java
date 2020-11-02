package tn.esprit.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import tn.esprit.spring.TimesheetApplication;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {
	@Autowired 
	IDepartementService dep;
	public static final Logger logger = Logger.getLogger(DepartementTest.class);
	@Test
	public void testModifyUser()  {
		assertEquals("Hello", "Hi");
	logger.info("Hello ");
	}
}
