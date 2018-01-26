package org.formation.spring.dao;

import java.util.List;

import org.formation.spring.entity.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface gestion de conseiller
 * @author HS NTH
 *
 */
public interface IDaoConseiller extends JpaRepository<Conseiller,Integer> {
	
	List<Conseiller> findAllConseillerByGerantId(int idGerant);
	
	public Conseiller findByLoginAndPwd(String login,String pwd );
}
