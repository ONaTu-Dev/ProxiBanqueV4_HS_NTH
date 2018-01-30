package org.formation.spring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
@NamedQueries({	@NamedQuery(name = "findAllVirements", query = "select m from Operation m"),
	//@NamedQuery(name = "findByDateAfter", query = "select m from Operation m where m.date >= :datedebut"),
	@NamedQuery(name = "findVirementByClientId", query = "select m from Operation m join m.client c where c.id = :clientid") })
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	 @JoinColumn(name = "id_client")
	 private Client client;

	private Date date;
	private int idcomptedepart;
	private int idcomptecible;
	private String numcomptedepart;
	private String numcomptecible;
	private double montant;
	private String etat;
	private String type;

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @param id
	 * @param date
	 * @param idcomptedepart
	 * @param idcomptecible
	 */
	public Operation( double montant, Date date, int idcomptedepart, int idcomptecible, String numdep, String numcib, String etat, String type) {
		this.date = date;
		this.montant=montant;
		this.idcomptedepart = idcomptedepart;
		this.idcomptecible = idcomptecible;
		this.numcomptedepart=numdep;
		this.numcomptecible=numcib;
		this.etat = etat;
		this.type=type;
	}

	public Operation() {
		// TODO Auto-generated constructor stub
	}

	public Double getMontant() {
		return this.montant;
	}

	public int getId() {
		return this.id;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * @return the idcomptedepart
	 */
	public int getIdcomptedepart() {
		return idcomptedepart;
	}

	/**
	 * @param idcomptedepart
	 *            the idcomptedepart to set
	 */
	public void setIdcomptedepart(int idcomptedepart) {
		this.idcomptedepart = idcomptedepart;
	}

	/**
	 * @return the idcomptecible
	 */
	public int getIdcomptecible() {
		return idcomptecible;
	}

	/**
	 * @param idcomptecible
	 *            the idcomptecible to set
	 */
	public void setIdcomptecible(int idcomptecible) {
		this.idcomptecible = idcomptecible;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	
	public void afficher() {
		System.out.println("Virement : id " + id + " date " + date + " compte depart " + idcomptedepart
				+ " compte cible " + idcomptecible+ " tyype "+type);
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat
	 *            the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Virement [id=" + id + ", date=" + date + ", idcomptedepart=" + idcomptedepart
				+ ", idcomptecible=" + idcomptecible + ", montant=" + montant + ", etat=" + etat + ", type=" + type
				+ "]";
	}

	public void setClient(Client client) {
		this.client=client;
		// TODO Auto-generated method stub
		
	}

	public String getNumcomptedepart() {
		return numcomptedepart;
	}

	public void setNumcomptedepart(String numcomptedepart) {
		this.numcomptedepart = numcomptedepart;
	}

	public String getNumcomptecible() {
		return numcomptecible;
	}

	public void setNumcomptecible(String numcomptecible) {
		this.numcomptecible = numcomptecible;
	}
	

}
