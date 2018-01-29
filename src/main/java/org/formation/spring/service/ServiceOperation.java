package org.formation.spring.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.formation.spring.dao.IDaoClient;
import org.formation.spring.dao.IDaoCompte;
import org.formation.spring.dao.IDaoOperation;
import org.formation.spring.entity.Client;
import org.formation.spring.entity.Compte;
import org.formation.spring.entity.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("serviceOperation")
public class ServiceOperation implements IServiceOperation {
	@Autowired
	private IDaoOperation daoOperation;
	@Autowired
	private IDaoClient daoClient;
	@Autowired
	private IDaoCompte daoCompte;
	final static double seuilmax = 9999;
	public static final Logger LOGGER = LoggerFactory.getLogger(ServiceOperation.class);



	/**
	 * vérifier que le montant ne dépasse pas le solde du compte
	 * 
	 * @param cl
	 * @param montant
	 * @return
	 */
	private boolean checkMontantSolde(Compte depart, double montant) {
		boolean isenought = false;
		LOGGER.debug("Montant demande :" + montant);
		if ((depart.getSolde() - montant) >= 1)
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
	private boolean ajoutSolde(Compte co, double montant) {
		boolean isOK = false;
		LOGGER.debug("Montant a ajouter :" + montant);
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
	private boolean suppSolde(Compte co, double montant) {
		boolean isOK = false;
		LOGGER.debug("Montant a retirer :" + montant);
		if (co != null) {
			double newsolde = co.getSolde() - montant;
			co.setSolde(newsolde);
			LOGGER.debug("Nouveau montant :" + newsolde);
			daoCompte.save(co);
			isOK = true;
		}
		return isOK;

	}

	/**
	 * Hypothese: limite de virement entre comptes de proxibanq 
	 * verifier que le
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

	public boolean createVirement(double montant, String depart, String cible, String type) {

		Operation vr = null;
		boolean retour = false;
		
		Compte dep=daoCompte.findCompteByNumeroCompte(depart);
		Compte cib=daoCompte.findCompteByNumeroCompte(cible);
		
		Date d=new Date();

		
		if ((dep==null)||(cib==null)) {
				System.out.println("-----------Seul les Virements Interne sont authorisés");
			return retour;
		}

		if (!checkMontantSolde(dep, montant)) {
			LOGGER.debug("-----------Virement interne echec. Montant transfert depasse le solde du compte depart. ");
			return retour;
		}

		Client c = dep.getClient();
		
		
		
		// Creation virement
		vr = new Operation(montant, d,dep.getid(), cib.getid(), depart, cible, "COMPTA", type);
		vr.afficher();

		LOGGER.debug("**********Afficher le client *********");
		c.affiche();
		
		LOGGER.debug("**********Ajout virement au client *********");
		vr.setClient(c);
		
		LOGGER.debug("**********SAVE VIREMENT TO DAO*********");
		daoOperation.save(vr);

		LOGGER.debug("**************Virement sauvergarde");

		//modifier le solde du compte depart ou compte cible
		 this.suppSolde(dep, montant);
		 LOGGER.debug("************compte depart maj avec nouveau sold");
		 this.ajoutSolde(cib, montant);
		 LOGGER.debug("************compte cible maj avec nouveau sold");
      	 return retour;
	}

	
	public boolean createVersement(double montant, String cible, String type) {

		Operation vr = null;
		boolean retour = false;
		
		Compte cib=daoCompte.findCompteByNumeroCompte(cible);

		cib.afficheCompte();
		if (cib.equals(null)) {
				System.out.println("-----------Seul les Virements Interne sont authorisés");
			return retour;
		}else {
			Client c = cib.getClient();
			
			Date d=new Date();
			
			// Creation virement
			vr = new Operation(montant, d,-1, cib.getid(), "", cible, "COMPTA", type);
			vr.afficher();

			LOGGER.debug("**********Afficher le client *********");
			c.affiche();
			
			LOGGER.debug("**********Ajout virement au client *********");
			vr.setClient(c);
			
			LOGGER.debug("**********SAVE VIREMENT TO DAO*********");
			daoOperation.save(vr);

			LOGGER.debug("**************Virement sauvergarde");

			 //modifier le solde du compte depart ou compte cible
			 this.ajoutSolde(cib, montant);
			 LOGGER.debug("************compte cible maj avec nouveau sold");
	      	 return retour;
		}

		
	}

	
	public List<Operation> getOperationsByIdClient(int idClient) {

		LOGGER.debug("----------Liste des virements d'un client---------");
		return daoOperation.findAllOperationsByClientId(idClient);

		// System.out.println("idclient " + idclient);
	}

	public void update(int idVirement) {
		Operation virement = daoOperation.getOne(idVirement);
		virement.setEtat("Annul�e");
		daoOperation.save(virement);
	}

	public List<Operation> getVirementsByIdClient(int idClient) {
		String type = "VIREMENT";
		List<Operation> list = daoOperation.findByClientIdAndType(idClient, type);
		return list;
	}

	public List<Operation> getVersementsByIdClient(int idClient) {
		String type = "VERSEMENT";
		List<Operation> list = daoOperation.findByClientIdAndType(idClient, type);
		return list;
	}

	public List<Operation> getAllOperations(int critere) {
		if (critere==1) {
			Date date = new Date();
		    Calendar c = Calendar.getInstance();
		    c.setTime(date);
		    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
		    c.add(Calendar.DATE, -i - 7);
		    Date datedebut = c.getTime();
		    System.out.println(datedebut+"°°°°°°date debut°°°°°°°°°°°°°°°°");
		    c.add(Calendar.DATE, 7);
		    Date dateend = c.getTime();
		    System.out.println(dateend+"°°°°°°°°°date fin°°°°°°°°°°°°°");
		    return daoOperation.findByDateAfter(datedebut);
		}
		if (critere==2) {
			Date date = new Date();
		    Calendar c = Calendar.getInstance();
		    Date dateend = c.getTime();
		    System.out.println(dateend+"°°°°°°°ddate fin°°°°°°°°°°°°°°");
		    c.setTime(date);
		    c.add(Calendar.DATE,- 30);
		    Date datedebut = c.getTime();
		    System.out.println(datedebut+"°°°°°°°°date debut°°°°°°°°°°°°°°");
		    return daoOperation.findByDateAfter(datedebut);
			
		}
		else return daoOperation.findAll();
	}
	
	public String getNumCompte(int idCompte)
	{
		Compte c = daoCompte.getOne(idCompte);
		LOGGER.debug("----------find num Compte");
		return c.getNumeroCompte();
	}

	
	
	
//	public boolean addVirement(Operation vir)
//	{
//		
//			boolean retour = false;
//			Client c = vir.getClient();
//			Compte dep=daoCompte.findOne(vir.getIdcomptedepart());
//			Compte cib=daoCompte.findOne(vir.getIdcomptecible());
//
//			
//			if ((dep==null)||(cib==null)) {
//					System.out.println("-----------Seul les Virements Interne sont authorisés");
//				return retour;
//			}
//
//			if (!checkMontantSolde(dep, vir.getMontant())) {
//				LOGGER.debug("-----------Virement interne echec. Montant transfert depasse le solde du compte depart. ");
//				return retour;
//			}

			
			
			// Creation virement
//			vr = new Operation(montant, d,depart, cible, dep.getNumeroCompte(), cib.getNumeroCompte(), "COMPTA", type);
//			vr.afficher();
//
//			LOGGER.debug("**********Afficher le client *********");
//			c.affiche();
//			
//			LOGGER.debug("**********Ajout virement au client *********");
//			vr.setClient(c);
//			
//			LOGGER.debug("**********SAVE VIREMENT TO DAO*********");
//			daoOperation.save(vr);
//
//			LOGGER.debug("**************Virement sauvergarde");
//
//			//modifier le solde du compte depart ou compte cible
//			 this.suppSolde(dep, montant);
//			 LOGGER.debug("************compte depart maj avec nouveau sold");
//			 this.ajoutSolde(cib, montant);
//			 LOGGER.debug("************compte cible maj avec nouveau sold");
//	      	 return retour;
//		}	
}

