package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;


public interface IDepartementService {
	
	
	public List<Departement> getAllDepartements();
	public int ajouterdepartement(Departement departement);

	
	
	

	
}
