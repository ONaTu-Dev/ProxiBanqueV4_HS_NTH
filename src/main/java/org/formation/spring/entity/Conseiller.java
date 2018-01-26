package org.formation.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * entity conseiller
 * @author NTH
 *
 */
@Entity
@Table(name = "conseiller")
public class Conseiller {

	private String nom;

	private String prenom;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(mappedBy = "conseiller", cascade = { CascadeType.PERSIST, CascadeType.REMOVE,CascadeType.MERGE})
	Set<Client> clients = new HashSet<Client>();

	@ManyToOne
	private Gerant gerant;
	@OneToOne
	private Agence agence;
	@Column(unique=true)
	private String login;
	private String pwd;

	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, Gerant gerant, Agence agence) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.gerant = gerant;
		this.agence = agence;
	}

	
	/**
	 * @param nom
	 * @param prenom
	 * @param gerant
	 * @param agence
	 * @param login
	 * @param pwd
	 */
	public Conseiller(String nom, String prenom, Gerant gerant, Agence agence, String login, String pwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.gerant = gerant;
		this.agence = agence;
		this.login = login;
		this.pwd = pwd;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
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
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 *            the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	public void addToListClient(Client client) {
		clients.add(client);
		client.setConseiller(this);
		
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
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
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conseiller [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", clients=" + clients + "]";
	}

}