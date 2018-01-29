package org.formation.spring.dto;

import org.formation.spring.entity.Adresse;
import org.formation.spring.entity.Conseiller;

public class BeanClient {
	private int id;
	private String nom;
	private String prenom;
	private String motDePasse;
	private String login;
	private String email;
	private Conseiller cons;
	private Adresse adresse;
	double soldeCC;
	double soldeEp;

	public BeanClient() {
	}

	public BeanClient(int id, String nom, String prenom, String motDePasse, String login, String email, Conseiller cons,
			Adresse adresse, double soldeCC, double soldeEp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.login = login;
		this.email = email;
		this.cons = cons;
		this.adresse = adresse;
		this.soldeCC = soldeCC;
		this.soldeEp = soldeEp;
	}

	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Conseiller getCons() {
		return cons;
	}

	public void setCons(Conseiller cons) {
		this.cons = cons;
	}

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
