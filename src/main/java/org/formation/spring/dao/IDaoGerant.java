package org.formation.spring.dao;

import org.formation.spring.entity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface gestion de gerant
 * @author HS NTH
 *
 */
public interface IDaoGerant extends JpaRepository<Gerant,Integer> {
	
	public Gerant findByLoginAndPwd(String login,String pwd );
	
}
