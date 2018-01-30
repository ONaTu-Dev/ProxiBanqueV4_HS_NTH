package org.formation.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * entity Client
 * @author NTH
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllClientByConseillerId", query = "select m from Client m join m.conseiller c where c.id = :conseillerid"), })
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nom;

	private String prenom;
	private String email;
	@Embedded
	private Adresse adresse;
	
	@OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private CompteCourant compteCourant;

	@OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private CompteEpargne compteEpargne;
	
	@ManyToOne()
	@JoinColumn(name = "id_conseiller")
	private Conseiller conseiller;
	// private int idConseiller;
	//@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST })
	//private Set<Virement> virements = new HashSet<Virement>();

	@OneToMany(mappedBy = "client", cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	private Set<Operation> virements = new HashSet<Operation>();

	public Client(String nom, String prenom,CompteCourant compteCourant, CompteEpargne compteEpargne, String email,Adresse ad) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		this.email = email;
		this.adresse=ad;
		
		
	}
	public Set<Operation> getVirements() {
		return virements;
	}
	public void setVirements(Set<Operation> virements) {
		this.virements = virements;
	}
	public Client(String nom, String prenom, String email,Adresse ad) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse=ad;
	}

	public Client() {

	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the compteCourant
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * @param compteCourant
	 *            the compteCourant to set
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	

	/**
	 * @return the compteEpargne
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	/**
	 * @param compteEpargne
	 *            the compteEpargne to set
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	/**
	 * @return the id
	 */

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}


	public void ajoutVirement(Operation virement) {
		System.out.println("**********METHODE ADD VIREMENT AAAAAAA*********");
		virements.add(virement);
	}

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * c'est une methode qui permet d'afficher les informations d'un client e.g ses
	 * coordonnees, ses comptes
	 */
	public void affiche() {
		System.out.println("Client: " + this.getNom() + " " + this.getPrenom() + " ");
		System.out.println(" Numero Identifiant " + this.id);
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ ", compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + ", conseiller=" + conseiller
				+ ", virements=" + virements + "]";
	}

//	public String toPrint() {
//		String s = "<br/>*******************************************<br/>" + " Numero Identifiant " + this.id_client
//				+ "<br/>" + " Nom: " + this.getNom() + "<br/>" + " Prenom " + this.getPrenom() + "<br/>" + " Adresse: "
//				+ this.adresse + "<br/>" + " CodePostal: " + this.codePostal + "<br/>" + " Telephone: " + this.telephone
//				+ "<br/>" + " Numero Conseiller: " + this.getConseiller().getId() + "<br/>";
//		// if (this.compteCourant != null)
		// this.compteCourant.toPrint();
		// if (this.compteEpargne != null)
		// this.compteEpargne.toPrint();
//		return s;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

}