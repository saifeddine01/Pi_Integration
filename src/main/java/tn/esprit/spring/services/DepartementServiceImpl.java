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
	int i=0;
	public List<Departement> getAllDepartements() {
		logger.info("In  retrieveAllDepartments : "); 
		List<Departement> listall =  (List<Departement>) deptRepoistory.findAll();
		for (Departement depart : listall) {
			logger.debug("items("+i+")" +"+++ : " + depart);
			i++;
		}
		logger.info("Out of retrieveAllDepartment"); 
		return listall;
	}
	@Override
	public int ajouterdepartement(Departement departement) {
		deptRepoistory.save(departement);
		return departement.getId();
	}
	
	@Override
	public void deleteDepartemetById(int departId) {
		logger.info("In  deleteDepartemetById : " ); 
		logger.info("Delete department :  *******************************"); 
		Departement deptodelete =deptRepoistory.findById(departId).get();
		logger.info("Delete department ID :  "+deptodelete.getId()); 
		deptRepoistory.delete(deptodelete);
		logger.info("Delete Succesful");
		logger.info("Out  deleteDepartemetById : " ); 
	}
	@Override
	public void EditDepartement(String departement, int depId) {
		logger.info("In  EditDepartement : " ); 
		Departement deptoEdit =deptRepoistory.findById(depId).get();
		deptoEdit.setName(departement);
		logger.debug("Change department successfully  "  +deptoEdit); 
		logger.info("Out  EditDepartement : " ); 
		
		
	}

}
