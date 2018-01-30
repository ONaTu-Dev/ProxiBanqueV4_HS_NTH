package org.formation.spring.dto;

import org.formation.spring.entity.Adresse;
import org.formation.spring.entity.Compte;
import org.formation.spring.entity.CompteCourant;
import org.formation.spring.entity.CompteEpargne;
import org.formation.spring.entity.Conseiller;

public class BeanClient {
	private int id;
	private String nom;
	private String prenom;
	private String motDePasse;
	private String login;
	private String email;
	//private int idcons =5;
	private Adresse adresse;
	private String numCompteCourant;
	private String numCompteEpargne;
//	private CompteCourant compteCourant;
//	private CompteEpargne compteEpargne;
	

	double soldeCC;
	double soldeEp;

	public BeanClient() {
	}

	public BeanClient(int id, String nom, String prenom, String motDePasse, String login, String email, int cons,
			Adresse adresse, double soldeCC, double soldeEp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.login = login;
		this.email = email;
		//this.idcons = cons;
		this.adresse = adresse;
		this.soldeCC = soldeCC;
		this.soldeEp = soldeEp;
	}

//	public CompteCourant getCompteCourant() {
//		return compteCourant;
//	}
//
//	public void setCompteCourant(CompteCourant compteCourant) {
//		this.compteCourant = compteCourant;
//	}
//
//	public CompteEpargne getCompteEpargne() {
//		return compteEpargne;
//	}
//
//	public void setCompteEpargne(CompteEpargne compteEpargne) {
//		this.compteEpargne = compteEpargne;
//	}
	
	

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BeanClient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse
				+ ", login=" + login + ", email=" + email +  ", adresse=" + adresse
				+ ", numCompteCourant=" + numCompteCourant + ", numCompteEpargne=" + numCompteEpargne + ", soldeCC="
				+ soldeCC + ", soldeEp=" + soldeEp + "]";
	}

	public String getNumCompteCourant() {
		return numCompteCourant;
	}

	public void setNumCompteCourant(String numCompteCourant) {
		this.numCompteCourant = numCompteCourant;
	}

	public String getNumCompteEpargne() {
		return numCompteEpargne;
	}

	public void setNumCompteEpargne(String numCompteEpargne) {
		this.numCompteEpargne = numCompteEpargne;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

//	public int getIdcons() {
//		return idcons;
//	}
//
//	public void setIdcons(int idcons) {
//		this.idcons = idcons;
//	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public int getCons() {
//		return idcons;
//	}
//
//	public void setCons(int cons) {
//		this.idcons = cons;
//	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public double getSoldeCC() {
		return soldeCC;
	}

	public void setSoldeCC(double soldeCC) {
		this.soldeCC = soldeCC;
	}

	public double getSoldeEp() {
		return soldeEp;
	}

	public void setSoldeEp(double soldeEp) {
		this.soldeEp = soldeEp;
	}

}
