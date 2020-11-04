package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Test
	public  void contextLoads() {
		Entreprise entr=new Entreprise("aaa","bbb");
		ientrepriseservice.ajouterEntreprise(entr);
		
	}
}
