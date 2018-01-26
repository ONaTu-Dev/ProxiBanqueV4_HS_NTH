package org.formation.spring.dao;

import org.formation.spring.entity.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface gestion d'un agence
 * @author HS NTH
 *
 */
public interface IDaoAgence extends JpaRepository <Agence,Integer>{

}
