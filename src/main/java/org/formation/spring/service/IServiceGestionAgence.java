package org.formation.spring.service;

import java.util.List;

import org.formation.spring.entity.Conseiller;
import org.formation.spring.entity.Gerant;

/**
 * Interface gestion agence, implementer tous les methodes CRUD de DaoAgence
 * @author HS NTH
 *
 */
public interface IServiceGestionAgence {

	public Gerant findByLoginAndPwd(String login,String pwd );
	
	public List<Conseiller> listConseillersByGerant();
}
