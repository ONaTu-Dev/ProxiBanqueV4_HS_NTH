package org.formation.spring.service;

import java.util.List;

import org.formation.spring.dao.IDaoGerant;
import org.formation.spring.entity.Conseiller;
import org.formation.spring.entity.Gerant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe qui regroupe tous les traitements concernant un agence courrant.
 * @author HS
 *
 */
@Service("AgenceService")
public class ServiceGestionAgence implements IServiceGestionAgence{

	@Autowired
	private IDaoGerant daoGerant;
	/**
	 * methode de trouver un gerant par son login et password
	 * @param login,password
	 */
	@Override
	public Gerant findByLoginAndPwd(String login, String pwd) {
		return daoGerant.findByLoginAndPwd(login, pwd);
	}
	/**
	 * methode de lister tous les conseillers d'un gerant
	 * @param login,password
	 */
	@Override
	public List<Conseiller> listConseillersByGerant() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
