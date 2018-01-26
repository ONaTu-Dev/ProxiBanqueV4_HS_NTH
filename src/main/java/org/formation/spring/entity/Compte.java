package org.formation.spring.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * entity compte abstract (strategy single table)
 * @author NTH
 *
 */
@Entity
@Table(name = "compte")
@DiscriminatorColumn(name = "compte_type", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
	//@NamedQuery(name = "findCRByClient", query = "select m from Compte m join m.client c where c.id =:id_client and m.compte_type=:COMPTE_COURANT")})
	@NamedQuery(name = " findAllCompteByClientId ", query = "select m from Compte m join m.client c where c.id =:idclient")})
	
	
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name="id_client")
	private Client client;
	private String numeroCompte;
	private double solde;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOuverture;

	public static final String PARTICULIER = "particulier";
	public static final String ENTREPRISE = "entreprise";

	public Compte(String numeroCompte, double solde) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = new Timestamp(System.currentTimeMillis());
	}
	public Compte() {
		super();
		this.solde = 0;
		this.dateOuverture = new Timestamp(System.currentTimeMillis());
	}
	

	/**
	 * @return the id
	 */
	public int getid() {
		return id;
	}

	/**
	 * @return the noCompte
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}
	/**
	 * @param noCompte the noCompte to set
	 */
	public void setNumeroCompte(String noCompte) {
		this.numeroCompte = noCompte;
	}
	/**
	 * @param id
	 *            the id to set
	 */
	public void setid(int id) {
		this.id = id;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * @param dateOuverture
	 *            the dateOuverture to set
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public double removeFromSolde(int montant) {
		double newSolde = this.getSolde() - montant;
		return newSolde;
	}

	public double addToSolde(int montant) {
		double newSolde = this.getSolde() + montant;
		return newSolde;
	}

	/**
	 * Méthode afficheCompte() est une méthode d'afficher les informations d'un
	 * compte comme le numéro de compte, sa date de l'ouverture et sa solde
	 */
	public void afficheCompte() {

		System.out.println("Numero de compte: " + this.id);
		System.out.println(" Date d'ouverture: " + this.dateOuverture);
		System.out.println(" Soldes: " + this.solde);

	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	public String toPrint() {

		String s = "Numero de compte: " + this.id + "<br/>" + " Date d'ouverture: " + this.dateOuverture + "<br/>"
				+ " Soldes: " + this.solde + "<br/>";
		return s;

	}
}
