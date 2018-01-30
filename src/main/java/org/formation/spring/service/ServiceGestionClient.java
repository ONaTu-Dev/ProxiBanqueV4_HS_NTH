package org.formation.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.formation.spring.dao.IDaoClient;
import org.formation.spring.dao.IDaoCompte;
import org.formation.spring.dao.IDaoConseiller;
import org.formation.spring.entity.Adresse;
import org.formation.spring.entity.Client;
import org.formation.spring.entity.Compte;
import org.formation.spring.entity.CompteCourant;
import org.formation.spring.entity.CompteEpargne;
import org.formation.spring.entity.Conseiller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Classe qui regroupe tous les traitements concernant un Conseiller courrant.
 * 		- Ajouter un Client
 * 		- Recuperer un Client par son ID, lire toutes ces informations (data)
 * 		- Modifier un Client
 * 		- Supprimer un Client
 * 		- Lister tous les Client dans persistence
 * 
 * 
 * DaoClient est injecte ici pour Chercher ou Modifier l'information dans persistance
 * 
 * @author NTH
 *
 */

@Service("serviceClient")
public class ServiceGestionClient implements IServiceGestionClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceGestionClient.class);
	@Autowired
	private IDaoClient daoClient;
	@Autowired
	private IDaoCompte daoCompte;
	@Autowired
	private IDaoConseiller daoConseiller;   

	public ServiceGestionClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * methode de persister un client d'un conseiller defini par son id dans la base de donnee
	 * @param Client, idConseiller
	 */
	
	public boolean addClientToConseiller(Client c,int idConseiller) {
		Conseiller conseiller = daoConseiller.getOne(idConseiller);
		LOGGER.debug("--------Add client to list---------");
		c.setConseiller(conseiller);
		LOGGER.debug("--------Add client---------");
		daoClient.save(c);
		LOGGER.info("--------client save---------");
		return true;
	}



	/**
	 * methode de modifier les informations concernant l'adressee d'un client et persiste dans la base
	 * @param Client
	 */
	public void updateClient(int id, Adresse adress) {
		Client client = daoClient.getOne(id);
		client.setAdresse(adress);
		daoClient.save(client);

	}

	/**
	 * methode de trouver un client grace a son id fournit
	 * @param Client
	 */
	public Client findClient(int id) {
		return daoClient.getOne(id);
	}

	/**
	 * methode de lister tous les clients 
	 * @param Client
	 */
	public List<Client> listClients() {
		return daoClient.findAll();
	}

	/**
	 * methode de lister tous les clients d'un conseiller
	 * @param Client
	 */
	public List<Client> listClientsByConseiller(int idConseiller) {
		return daoClient.findAllClientByConseillerId(idConseiller);
	}

	/**
	 * methode d'ajouter un compte soit compte courant, soit compte epargne au client donne
	 * @param Client
	 */

	public void addCompte(int idClient, Compte compte)
	{
		Client client = daoClient.getOne(idClient);
		compte.setClient(client);
		daoCompte.save(compte);
	}
	public void addCompteToClient(int idClient, Compte compte) {
		Client client = daoClient.getOne(idClient);
		if (CompteCourant.class.isAssignableFrom(compte.getClass())) {
			CompteCourant cc = (CompteCourant) compte;

			LOGGER.debug("-------Client Set compte -------");
			cc.setClient(client);
			LOGGER.debug("-------save compte-----");
			daoCompte.save(cc);
			

		}
		if (CompteEpargne.class.isAssignableFrom(compte.getClass())) {
			CompteEpargne ep = (CompteEpargne) compte;
			ep.setClient(client);
			daoCompte.save(ep);

		}

	}

	/**
	 * methode de lister tous les comptes possedes par un client dont id bien donnee
	 * @param Client
	 */
	public List<Compte> listCompteByClientId(int id) {
		return daoCompte.findAllCompteByClientId(id);
	}
	
	/**
	 * methode de chercher et trouver un compte courant d'un client dont id bien donnee
	 * @param id client
	 */
	public CompteCourant findCompteCourantByClientId(int id) {
		List<Compte> list = this.listCompteByClientId(id);
		CompteCourant c = null;
		for (Compte cpte : list) {
			if (CompteCourant.class.isAssignableFrom(cpte.getClass()))
	
			{
				c = (CompteCourant) cpte;
			}
		}
		return c;
	}
	/**
	 * methode de chercher et trouver le compte epargne possede par un client dont id bien donnee
	 * @param id client
	 */
	public CompteEpargne findCompteEpargneByClientId(int id) {
		List<Compte> list = this.listCompteByClientId(id);
		CompteEpargne c = null;
		for (Compte cpte : list) {
			if (CompteEpargne.class.isAssignableFrom(cpte.getClass()))
				
			{
				c = (CompteEpargne) cpte;
			}
		}
		return c;
	}
	public List<Client> findAllClientByNom(String nom){
		return daoClient.findAllClientByNomIgnoreCase(nom);
	}

	public List<Client> findAllClientByPrenom(String prenom){
		return daoClient.findAllClientByPrenomIgnoreCase(prenom);
	}

}
