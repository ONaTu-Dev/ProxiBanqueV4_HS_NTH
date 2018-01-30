package org.formation.spring.dao;

import java.util.Date;
import java.util.List;

import org.formation.spring.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface gestion de virement
 * @author HS NTH
 *
 */
public interface IDaoOperation extends JpaRepository<Operation, Integer> {
	List<Operation> findByClientIdAndType(int idClient, String type);
	List<Operation> findAllOperationsByClientId(int idClient);
	List<Operation> findByDateAfter(Date datedebut);
}
