package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import tn.esprit.spring.TimesheetApplication;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {
	@Autowired 
	IDepartementService dep;
	public static final Logger logger = Logger.getLogger(DepartementTest.class);
	int depid;
	@Test
	public void addDepartment()  {
		logger.info("Debut test add department : ");
		Departement dp = new Departement("TECHNIQUE");
		depid =dep.ajouterdepartement(dp);
		logger.info(depid);
		assertEquals(depid, dp.getId());
		logger.info("Finish testing");
	}
	@Test
	public void GetAlDepartments()  {
		logger.info("Get all depeartment callign ");
		List<Departement> listDep = dep.getAllDepartements(); 
		// if there are 5 users in DB : 
		assertEquals(5, listDep.size());
	}
}
