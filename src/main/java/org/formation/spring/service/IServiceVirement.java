package org.formation.spring.service;

import java.util.Date;
import java.util.List;

import org.formation.spring.entity.Virement;

public interface IServiceVirement {
	public boolean isVirementInterne(int depart, int cible);
	public boolean checkCompte(int c);
	public boolean createVirement(int idclient, double montant, Date d, int depart, int cible, String type);
	public List<Virement> getOperationsByIdClient(int idClient);
	public void update(int idVirement);
	public List<Virement> getAllOperations();
	
}
