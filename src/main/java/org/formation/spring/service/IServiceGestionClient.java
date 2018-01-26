package org.formation.spring.service;

import java.util.List;

import org.formation.spring.entity.Adresse;
import org.formation.spring.entity.Client;
import org.formation.spring.entity.Compte;

/**
 * Interface de service gestion client d'un conseiller, implement les methodes CRUD de DaoClient
 * @author NTH
 *
 */
public interface IServiceGestionClient {

	
	public boolean addClientToConseiller(Client c, int idConseiller);

	public Client findClient(int id);

	public List<Client> listClients();

	public List<Client> listClientsByConseiller(int id);

	public void updateClient(int id, Adresse adress);

	public void addCompteToClient(int idClient, Compte compte);

	public List<Compte> listCompteByClientId(int id);
}
