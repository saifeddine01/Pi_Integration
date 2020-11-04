package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	@Autowired
	ContratRepository contratRepository;
	private static final Logger l = Logger.getLogger(ContratServiceImpl.class);

	
	public Contrat addContrat(Contrat contrat) {
		contratRepository.save(contrat);
		l.info("ajout du contrat avec succes"+contrat);
		return contrat;
	}

	public Contrat findcontrat(int ref) {
		return contratRepository.findById(ref).orElse(null);
	}
	public void deleteContrat(Contrat contrat) {
		contratRepository.delete(contrat);
		l.info("supprimer le contrat avec succes"+contrat);
	}
	public List<Contrat> getAllContrats() {
		
		return (List<Contrat>) contratRepository.findAll();
	}

}