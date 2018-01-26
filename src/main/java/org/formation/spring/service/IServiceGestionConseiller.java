package org.formation.spring.service;

import java.util.List;

import org.formation.spring.entity.Agence;
import org.formation.spring.entity.Client;
import org.formation.spring.entity.Conseiller;
import org.formation.spring.entity.Gerant;

/**
 * Interface de service gestion des conseillers d'un gerant, appelle les methode CRUD de DaoConseiller
 * @author NTH
 *
 */
public interface IServiceGestionConseiller {
	public boolean addConseillerToGerant(Conseiller conseiller,int idGerant);

	public boolean addGerant(Gerant gerant,int idAgence);

	public boolean createAgence(Agence agence);

	public Conseiller findConseiller(int id);

	public List<Conseiller> listConseillersByGerant(int idGerant);
	
	public Conseiller findByLoginAndPwd(String login,String pwd );
	
	
}
