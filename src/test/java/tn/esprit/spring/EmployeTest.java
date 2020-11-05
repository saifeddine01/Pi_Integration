package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	

	@Autowired 
	IEmployeService es; 

	public static final Logger logger = Logger.getLogger(EmployeTest.class);

	
	@Test
	public void TestAddorUpdate() throws ParseException {
		logger.info("-------Starting Add or Update--------"); 
		Employe u = new Employe("Jassem", "Ben Rayana","jassem@gmail.com","123456", true, Role.TECHNICIEN);
		int EmployeID = es.addOrUpdateEmploye(u); 
		logger.info("ID of Employe is :" + EmployeID);
		assertEquals(EmployeID, u.getId());
		logger.info("-------Finished Add or Update--------"); 
	}
	
	@Test
	public void TestGetEmployeNumber() {
		logger.info("-------Starting Counting Employees-------");
		es.getNombreEmployeJPQL();
		logger.info("-------Finished Counting of Employees--------"); 
	}
	
	@Test
	public void TestGetAllEmployees()  {
		logger.info("-------Get all Employees Starting-------");
		List<Employe> listEmploye = es.getAllEmployes(); 
		logger.info("Employees Are : " + listEmploye);
		logger.info("-------Get all Employees Finished-------");
	}
	
	@Test
	public void TestAffecterContractToEmploye()  {
		logger.info("-------Affaction Contract to Employe Starting-------");
		int contratID = 1;
		int EmployeID = 5;
		es.affecterContratAEmploye(contratID, EmployeID);
		
		logger.info("Contrat with ID "+ contratID + " is affected to Employe with ID " + EmployeID );
		
		logger.info("-------Affaction Contract to Employe Finished-------");
	}
	
	@Test
	public void TestDeleteEmploye()  {
		logger.info("-------Delete Employe Starting-------");
		int EmployeID = 6;
		es.deleteEmployeById(EmployeID);
		logger.info("Employe with ID " + EmployeID + " is deleted");
		logger.info("-------Delete Employe Finished-------");
	}
}
