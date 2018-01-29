package org.formation.spring.service;

import java.util.List;

import org.formation.spring.entity.Operation;

public interface IServiceOperation {
	public boolean checkCompte(int c);
	public boolean createVirement(double montant, String depart, String cible, String type);
	public boolean createVersement(double montant, String cible, String type);
	public List<Operation> getOperationsByIdClient(int idClient);
	public void update(int idVirement);
	public List<Operation> getAllOperations(int critere);
	public String getNumCompte(int idCompte);
	
}
