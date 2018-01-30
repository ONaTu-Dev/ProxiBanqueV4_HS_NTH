package org.formation.spring.entity;

import java.util.Date;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * entity compte courant
 * @author NTH
 *
 */
@Entity
@DiscriminatorValue(value = "COMPTE_COURANT")
public class CompteCourant extends Compte {
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;*/

	 public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	@OneToOne(mappedBy = "compteCourant", cascade = { CascadeType.PERSIST,
	 CascadeType.MERGE, CascadeType.REMOVE })

	 private CarteBancaire carteBancaire;
	public static final double MAXI_DECOUVERT_PARTICULIER = -5000d;
	public static final double MAXI_DECOUVERT_ENTREPRISE = -50000d;

	private static final double DEFAULT_DECOUVERT = 1000d;
	private double autorisationDecouvert;

	public CompteCourant(String numCarte) {
		super();
		this.autorisationDecouvert = DEFAULT_DECOUVERT;
		// Attribuer une carte par defaut
		this.setCarteBancaire(new VisaElectron(numCarte));
	}

	

	public CompteCourant(String numeroCompte, double solde) {
		super(solde);
	}

	public CompteCourant(double solde, String numCarte, double autorisationDecouvert) {
		super(solde);
		// this.carteBancaire = carteBancaire;
		this.autorisationDecouvert = autorisationDecouvert;
		this.setCarteBancaire(new VisaElectron(numCarte));
	}


	public CompteCourant() {
		super();
	}

	/**
	 * @return the autorisationDecouvert
	 */
	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	/**
	 * @param autorisationDecouvert
	 *            the autorisationDecouvert to set
	 */
	public void setAutorisationDecouvert(double autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}

	@Override
	public void afficheCompte() {
		// TODO Auto-generated method stub
		System.out.println(" Le compte courant");
		super.afficheCompte();
		// System.out.println("Le numero de carte bancaire
		// "+this.carteBancaire.toString());
	}

	@Override
	public String toString() {
		return "CompteCourant ["
				+ super.toString()+ ", carteBancaire=" +  ", autorisationDecouvert="
				+ autorisationDecouvert + "]";
	}

	

}