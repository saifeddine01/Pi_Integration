package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {
	
@Autowired
IContratService icontratservice;

	@Test
	public void contextLoads() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
		Date debut = dateFormat.parse("21/10/2020");
	
		Contrat contrat = new Contrat(debut, "location",25f);
		icontratservice.addContrat(contrat);
	}

	
	
		
}
