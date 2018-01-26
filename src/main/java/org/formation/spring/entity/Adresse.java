package org.formation.spring.entity;

import javax.persistence.Embeddable;

/**
 * Entity adresse EMBEDDED dans Client et Employee
 * @author HS NTH
 *
 */
@Embeddable
public class Adresse {
	private String adresse;

	private int codePostal;

	private String ville;

	private String telephone;

	public Adresse(String adresse, int codePostal, String ville, String telephone) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	public Adresse() {
		super();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Adresse [adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone="
				+ telephone + "]";
	}
	
}
