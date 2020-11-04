package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {
	

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	private static final Logger logger = Logger.getLogger(TimesheetServiceImpl.class);

	
	public int ajouterMission(Mission mission) {
		logger.info("Debut d'éxcution de l'ajout de mission");
		logger.debug("Ajout de l'entité mission");
		missionRepository.save(mission);
		logger.info("fini d'éxcution");
		logger.debug("Retour de l'id de la mission ajoutée");
		return mission.getId();
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		logger.info("Debut d'éxcution de l'affectation missionId");
		logger.debug("Affecter missionId");
		Mission mission = missionRepository.findById(missionId).get();
		logger.info("fini d'éxcution");
		logger.info("Debut d'éxcution de l'affectation DepartementId");
		logger.debug("Affecter departementId");
		Departement dep = deptRepoistory.findById(depId).get();
		logger.info("fini d'éxcution");
		logger.info("Debut d'éxcution de la récupération Departement");
		logger.debug("Affecter departement");
		mission.setDepartement(dep);
		logger.info("fini d'éxcution");
		logger.info("Debut d'éxcution de la affectation de mission");
		logger.debug("Affecter de la mission");
		missionRepository.save(mission);
		logger.info("fini d'éxcution");

	}

	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		logger.info("Debut d'éxcution de l'ajoutTimesheetPK");
		logger.debug("Ajout de TimesheetPK");
		TimesheetPK timesheetPK = new TimesheetPK();
		logger.info("fin d'éxcution");
		
		logger.debug("Ajout de dateDebut");
		timesheetPK.setDateDebut(dateDebut);
		logger.debug("Ajout de dateFin");
		timesheetPK.setDateFin(dateFin);
		logger.debug("Ajout de EmployeId");
		timesheetPK.setIdEmploye(employeId);
		logger.debug("Ajout de missionId");
		timesheetPK.setIdMission(missionId);
		
		logger.info("Debut d'éxcution de l'ajoutTimesheet");
		logger.debug("Ajout de Timesheet");
		Timesheet timesheet = new Timesheet();
		logger.info("fin d'éxcution");
		logger.debug("récupérer de TimesheetPK");
		timesheet.setTimesheetPK(timesheetPK);
		logger.debug("Vérification");
		timesheet.setValide(false); //par defaut non valide
		logger.debug("Enregistrement");
		timesheetRepository.save(timesheet);
		
	}

	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		System.out.println("In valider Timesheet");
		Employe validateur = employeRepository.findById(validateurId).get();
		Mission mission = missionRepository.findById(missionId).get();
		//verifier s'il est un chef de departement (interet des enum)
		if(!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){
			System.out.println("l'employe doit etre chef de departement pour valider une feuille de temps !");
			return;
		}
		//verifier s'il est le chef de departement de la mission en question
		boolean chefDeLaMission = false;
		for(Departement dep : validateur.getDepartements()){
			if(dep.getId() == mission.getDepartement().getId()){
				chefDeLaMission = true;
				break;
			}
		}
		if(!chefDeLaMission){
			System.out.println("l'employe doit etre chef de departement de la mission en question");
			return;
		}
//
		TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
		Timesheet timesheet =timesheetRepository.findBytimesheetPK(timesheetPK);
		timesheet.setValide(true);
		
		//Comment Lire une date de la base de données
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("dateDebut : " + dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));
		
	}

	
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
	}

	
	public List<Employe> getAllEmployeByMission(int missionId) {
		return timesheetRepository.getAllEmployeByMission(missionId);
	}

}
