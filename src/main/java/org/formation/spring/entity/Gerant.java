package org.formation.spring.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity gerant
 * @author NTH
 *
 */
@Entity
@Table(name = "gerant")
public class Gerant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public static final char ROLE_GERANT = 'G';
	private String nom;
	private String prenom;
	@Column(unique=true)
	private String login;
	private String pwd;
	// private String refEmployee;
	// @Embedded
	// private Adresse adresse;
	@OneToOne
	private Agence agence;

	@OneToMany(mappedBy = "gerant", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Conseiller> conseillerList = new ArrayList<>();

	public Gerant() {
		super();
		// super.setRole(ROLE_GERANT);
	}

	// public Gerant(String nom, String prenom, String refEmployee, Adresse adresse)
	// {
	// super(nom, prenom, refEmployee, adresse);
	// super.setRole(ROLE_GERANT);
	// }

	public Agence getAgence() {
		return agence;
	}

	public Gerant(String nom, String prenom, Agence agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.agence = agence;
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param pwd
	 * @param agence
	 */
	public Gerant(String nom, String prenom, String login, String pwd, Agence agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
		this.agence = agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Conseiller> getConseillerList() {
		return conseillerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setConseillerList(List<Conseiller> conseillerList) {
		this.conseillerList = conseillerList;
	}

	public void addConseiller(Conseiller c) {
		c.setGerant(this);
		conseillerList.add(c);
	}

	public void deleteConseiller(Conseiller c) {
		c.setGerant(null);
		conseillerList.remove(c);
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
