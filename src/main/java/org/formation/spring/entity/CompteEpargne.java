package org.formation.spring.entity;

import java.util.Date;
import java.util.Vector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * entity compte epargne
 * @author NTH
 *
 */
@Entity
@DiscriminatorValue(value = "COMPTE_EPARGNE")
public class CompteEpargne extends Compte {

	public static final double TAUX=0.03;
	private double tauxRemuneration;
	public CompteEpargne(String numeroCompte, double solde) {
		super(numeroCompte, solde);
		this.tauxRemuneration=TAUX;
		// TODO Auto-generated constructor stub
	}
	public CompteEpargne() {
		super();
	}
//	public CompteEpargne(String idCompte) {
//		super(idCompte);
//		this.tauxInteret = 0.03d;
//	}

	


	/**
	 * @return the tauxRemuneration
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	/**
	 * @param tauxRemuneration the tauxRemuneration to set
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
}