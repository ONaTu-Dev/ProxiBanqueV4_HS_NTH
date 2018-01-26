package org.formation.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.formation.spring.entity.Client;
import org.formation.spring.entity.CompteCourant;
import org.formation.spring.entity.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Gestion d'un client
 * @author HS NTH
 *
 */
public interface IDaoClient extends JpaRepository<Client,Integer> {
	
	
	
	List<Client> findAllClientByConseillerId(int idConseiller);
	

}
