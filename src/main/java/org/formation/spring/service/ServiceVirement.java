package org.formation.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.formation.spring.dao.IDaoClient;
import org.formation.spring.dao.IDaoCompte;
import org.formation.spring.dao.IDaoVirement;
import org.formation.spring.entity.Compte;
import org.formation.spring.entity.Virement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.formation.spring.entity.Client;
import org.formation.spring.entity.CompteCourant;
import org.formation.spring.entity.CompteEpargne;

/**
 * /** Classe qui regroupe tous les traitements concernant un virement -
 * 
 * 
 * daoVierment est utilise ici pour Chercher ou Modifier l'information dans
 * persistance *
 * 
 * @author NTH
 *
 */
@Service("serviceVirement")
public class ServiceVirement implements IServiceVirement {
	@Autowired
	private IDaoVirement daoVirement;
	@Autowired
	private IDaoClient daoClient;
	@Autowired
	private IDaoCompte daoCompte;
	final static double seuilmax = 9999;
	public static final Logger LOGGER = LoggerFactory.getLogger(ServiceVirement.class);

	/**
	 * verifier que le montant ne dï¿½passe pas le seuil autorisï¿½ utilisï¿½ pour
	 * un virement vers un compte d'un autre client
	 * 
	 * @param cl
	 * @param montant
	 * @return
	 */
	private boolean checkMontantSeuil(double montant) {
		boolean isauthor = true;
		if (montant > seuilmax) {
			LOGGER.debug("Montant du virement depasse le seuil " + seuilmax);
			isauthor = false;
		} else
			LOGGER.info("Montant du virement en dessous le seuil : OK");
		return isauthor;
	}

	// public boolean faireVirement(Client debiteur, Compte depart, Client
	// crediteur, Compte cible, double montant) {
	// if (this.checkMontantSolde(depart, montant)) {
	//
	// depart.setSolde(depart.getSolde() - montant);
	// cible.setSolde(cible.getSolde() + montant);
	//// Virement virement = new Virement(debiteur, crediteur, depart, cible,
	// montant);
	//// virement.setStatus("Effectue");
	//// daoVirement.save(virement);
	//
	// return true;
	// } else
	// return false;
	// }

	/**
	 * vÃ©rifier que le montant ne dÃ©passe pas le solde du compte
	 * 
	 * @param cl
	 * @param montant
	 * @return
	 */
	private boolean checkMontantSolde(int depart, double montant) {
		boolean isenought = false;
		LOGGER.debug("Montant demande :" + montant);
		if (((daoCompte.findOne(depart)).getSolde() - montant) >= 1)
			isenought = true;
		if (!isenought) {
			LOGGER.debug("----------solde depart insuffisant---------");

		} else
			LOGGER.debug(" ********SOLDE OK********");

		return isenought;

	}

	/**
	 * Ajouter un montant dans le solde du compte
	 * 
	 * @param c
	 * @param montant
	 * @return
	 */
	private boolean ajoutSolde(int c, double montant) {
		boolean isOK = false;
		LOGGER.debug("Montant à  ajouter :" + montant);
		Compte co = daoCompte.findOne(c);
		if (co != null) {
			double newsolde = co.getSolde() + montant;
			co.setSolde(newsolde);
			daoCompte.save(co);
			isOK = true;
		}
		return isOK;

	}

	/**
	 * Supprimer un montant du solde du compte
	 * 
	 * @param c
	 * @param montant
	 * @return
	 */
	private boolean suppSolde(int c, double montant) {
		boolean isOK = false;
		LOGGER.debug("Montant à  retirer :" + montant);
		Compte co = daoCompte.findOne(c);
		if (co != null) {
			double newsolde = co.getSolde() - montant;
			co.setSolde(newsolde);
			daoCompte.save(co);
			isOK = true;
		}
		return isOK;

	}

	/**
	 * vÃ©rifier si le virement est un virement interne entre les comptes d'un mÃªme
	 * client
	 * 
	 * @param cl
	 * @param cible
	 * @return
	 */

	public boolean isVirementInterne(int depart, int cible) {
		boolean isInterne = false;
		if (checkCompte(depart) && checkCompte(cible))
			isInterne = true;
		return isInterne;
	}

	/**
	 * Hypothese: limite de virement entre comptes de proxibanq verifier que le
	 * compte est dans la liste des comptes proxibanque
	 * 
	 * @param c
	 * @return
	 */

	public boolean checkCompte(int c) {
		boolean isexist = false;
		isexist = daoCompte.exists(c);
		if (!isexist) {
			System.out.println("-----Compte inexistant dans la liste des comptes connu:");
		} else
			System.out.println("*************Verification compte : OK***********");
		return isexist;
	}

	// public void setVirementForClient(int idClient, Virement vr) {
	// Client c = daoClient.getOne(idClient);
	// LOGGER.debug("---------list");
	//// Set<Virement> list = c.getVirements();
	//// LOGGER.debug("---------list");
	// vr.setClient(c);
	//// c.getVirements().add(vr);
	// daoClient.save(c);
	// daoVirement.save(vr);
	//
	// }

	public boolean createVirement(int idclient, double montant, Date d, int depart, int cible, String type) {

		Virement vr = null;
		boolean retour = false;
		Client c = daoClient.getOne(idclient);

		if (!checkCompte(depart)) {
			LOGGER.debug("-----------Virement interne echec. Compte depart inexiste. ");
			return retour;
		}

		if (!checkMontantSolde(depart, montant)) {
			System.out.println(
					"-----------Virement interne echec. Montant transfert depasse le solde du compte depart. ");
			return retour;
		}

		boolean isInterne = isVirementInterne(depart, cible);
		if (!isInterne) {
			if (!checkMontantSeuil(montant))
				System.out.println("-----------Virement externe echec. Montant depasse montant seuil. ");
			return retour;
		}

		// Creation virement
		vr = new Virement(montant, d, depart, cible, "COMPTA", type);

		LOGGER.debug("***********Virement montant --" + montant);

		vr.afficher();

		LOGGER.debug("idclient " + idclient);

		// this.setVirementForClient(idclient, vr);
		// vr.setClient(c);

		c.addVirement(vr);
		// daoClient.save(c);

		daoVirement.save(vr);

		LOGGER.debug("**************Virement sauvergarde, yeahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh ");

		// modifier le solde du compte depart et/ou compte cible

		// if (isInterne) {
		// this.ajoutSolde(cible, montant);
		// this.suppSolde(depart, montant);
		// }else {
		// //si le compte cible n'est dans notre banque, on supprime
		// //seulement le montant du compte dÃepart
		// this.suppSolde(depart, montant);
		// }

		return retour;
	}

	public List<Virement> getOperationsByIdClient(int idClient) {

		LOGGER.debug("----------Liste des virements d'un client---------");
		return daoVirement.findAllOperationsByClientId(idClient);

		// System.out.println("idclient " + idclient);
	}

	public void update(int idVirement) {
		Virement virement = daoVirement.getOne(idVirement);
		virement.setEtat("Annulée");
		daoVirement.save(virement);
	}

	public List<Virement> getVirementsByIdClient(int idClient) {
		String type = "VIREMENT";
		List<Virement> list = daoVirement.findByClientIdAndType(idClient, type);
		return list;
	}

	public List<Virement> getVersementsByIdClient(int idClient) {
		String type = "VERSEMENT";
		List<Virement> list = daoVirement.findByClientIdAndType(idClient, type);
		return list;
	}

	public List<Virement> getAllOperations() {
		return daoVirement.findAll();
	}
}
