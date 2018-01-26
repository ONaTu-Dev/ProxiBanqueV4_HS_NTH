package org.formation.spring.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * entity visa carte
 * @author NTH
 *
 */
@Entity
@DiscriminatorValue(value = "ELECTRON")
public class VisaElectron extends CarteBancaire {

	public VisaElectron(String numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}
}