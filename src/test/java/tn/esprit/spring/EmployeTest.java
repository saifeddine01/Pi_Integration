package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

import java.text.ParseException;

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
		Employe u = new Employe("Jassem", "Ben Rayana","jassem@gmail.com","123456", true, Role.TECHNICIEN);
		int EmployeID = es.addOrUpdateEmploye(u); 
		assertEquals(EmployeID, u.getId());
	}
}
