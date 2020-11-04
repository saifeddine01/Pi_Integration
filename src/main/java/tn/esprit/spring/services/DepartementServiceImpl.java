package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {


	@Autowired
	DepartementRepository deptRepoistory;
	
	public static final Logger logger = Logger.getLogger(DepartementServiceImpl.class);

	public List<Departement> getAllDepartements() {
		logger.info("In  retrieveAllDepartments : "); 
		List<Departement> listall =  (List<Departement>) deptRepoistory.findAll();
		for (Departement depart : listall) {
			logger.debug("depart +++ : " + depart);
		}
		logger.info("Out of retrieveAllDepartment"); 
		return listall;
	}
	@Override
	public int ajouterdepartement(Departement departement) {
		deptRepoistory.save(departement);
		return departement.getId();
	}

}
