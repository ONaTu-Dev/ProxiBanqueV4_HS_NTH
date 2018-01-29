package org.formation.spring.dao;

import java.util.List;

import org.formation.spring.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Iterface Gestion de comptes
 * @author HS NTH
 *
 */
public interface IDaoCompte extends JpaRepository<Compte,Integer> {

	
	List<Compte> findAllCompteByClientId(int id);
	Compte findCompteByNumeroCompte(String numeroCompte);

}
