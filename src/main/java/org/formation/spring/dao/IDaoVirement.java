package org.formation.spring.dao;

import java.util.List;

import org.formation.spring.entity.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface gestion de virement
 * @author HS NTH
 *
 */
public interface IDaoVirement extends JpaRepository<Virement, Integer> {
	List<Virement> findByClientIdAndType(int idClient, String type);
	List<Virement> findAllOperationsByClientId(int idClient);
	
}
