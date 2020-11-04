package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public Contrat findcontrat(int ref) ;
	public void deleteContrat(Contrat contrat);
	public Contrat addContrat(Contrat contrat);
	
	
	

	
}
