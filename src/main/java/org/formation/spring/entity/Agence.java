package org.formation.spring.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity Agence
 * @author NTH
 *
 */
@Entity
@Table(name = "agence")
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String reference;
	private String dateCretion;
	@OneToOne(mappedBy = "agence", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_gerant")
	private Gerant gerant;
	@OneToMany(mappedBy = "agence", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Conseiller> conseillers = new HashSet<Conseiller>();

	public Agence(int id, String dateCretion, Gerant gerant, Set<Conseiller> conseillers) {
		super();
		this.id = id;
		this.dateCretion = dateCretion;
		this.gerant = gerant;
		this.conseillers = conseillers;
	}

	public Agence(String reference, String dateCretion) {
		super();
		this.reference = reference;
		this.dateCretion = dateCretion;
	}

	public Agence() {
		super();
	}

	public Agence(String reference) {
		// TODO Auto-generated constructor stub
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dateCretion
	 */
	public String getDateCretion() {
		return dateCretion;
	}

	/**
	 * @param dateCretion
	 *            the dateCretion to set
	 */
	public void setDateCretion(String dateCretion) {
		this.dateCretion = dateCretion;
	}

	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * @param gerant
	 *            the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * @return the conseillers
	 */
	public Set<Conseiller> getConseillers() {
		return conseillers;
	}

	/**
	 * @param conseillers
	 *            the conseillers to set
	 */
	public void setConseillers(Set<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public void removeConseiller(Integer id) {
	}

	public void addConseiller(Conseiller conseiller) {

	}

}