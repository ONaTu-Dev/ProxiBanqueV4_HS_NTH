package org.formation.spring.service;

import java.util.List;

import org.formation.spring.dao.IDaoAgence;
import org.formation.spring.dao.IDaoConseiller;
import org.formation.spring.dao.IDaoGerant;
import org.formation.spring.entity.Agence;
import org.formation.spring.entity.Conseiller;
import org.formation.spring.entity.Gerant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * /**
 * Classe qui regroupe tous les traitements concernant un Gerant courrant. -
 * Ajouter un conseiller Audit
 * 
 * daoAgence est injecte ici pour Chercher ou Modifier l'information dans
 * persistance *
 * @author NTH
 *
 */

@Service("gerantService")
public class ServiceGestionConseiller implements IServiceGestionConseiller {
@Autowired
private IDaoConseiller daoConseiller;
@Autowired
private IDaoGerant daoGerant;
@Autowired
private IDaoAgence daoAgence;
private static final Logger LOGGER = LoggerFactory.getLogger(ServiceGestionClient.class);
	
/**
 *  methode de persister un conseillert d'un gerant defini par son id dans la base de donnee
 * @param conseiller, idgerant
 */
	@Override
	public boolean addConseillerToGerant(Conseiller conseiller,int idGerant) {
		
		Gerant gerant = daoGerant.getOne(idGerant);
		LOGGER.debug("--------Add conseiller to list---------");
		conseiller.setGerant(gerant);
		LOGGER.info("--------conseiller save---------");
		daoConseiller.save(conseiller);
		return true;
	}
	/**
	 *  methode de persister un gerant d'un agence defini par son id dans la base de donnee
	 * @param cgerant, idAgence
	 */
	public boolean addGerant(Gerant gerant,int idAgence) {
		Agence agence=daoAgence.getOne(idAgence);
		gerant.setAgence(agence);
		daoGerant.save(gerant);
		return true;
	}
	/**
	 *  methode de persister un agence dans la base de donnee
	 * @param agence
	 */
	public boolean createAgence(Agence agence) {
		daoAgence.save(agence);
		return true;
	}
	/**
	 * methode de chercher et trouver un conseiller dans la persistence grace a son id
	 * @param id
	 */
	@Override
	public Conseiller findConseiller(int id) {
		// TODO Auto-generated method stub
	return daoConseiller.getOne(id);
	}
	/**
	 *  methode de lister tous les conseillers d'un gerant grace a id de gerant
	 * @param id
	 */
	@Override
	public List<Conseiller> listConseillersByGerant(int id) {
			return daoConseiller.findAllConseillerByGerantId(id);
	}
	/**
	 * methode de trouver un conseiller par son login et password
	 * @param  login, password
	 */
	@Override
	public Conseiller findByLoginAndPwd(String login, String pwd) {
	return daoConseiller.findByLoginAndPwd(login, pwd);
	}

	
	
}
