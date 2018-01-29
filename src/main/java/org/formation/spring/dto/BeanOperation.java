package org.formation.spring.dto;

import java.util.Date;

public class BeanOperation {
	private int id;
	private int idclient;
	private String nomClient;
	private String prenomClient;
	private Date date;
	private int idCompteDepart;
	private int idCompteCible;
	private String numCompteDepart;
	private String numCompteCible;
	private double montant;
	private String etat;
	private String typeoper;
	private int critere;

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getNumCompteDepart() {
		return numCompteDepart;
	}

	public void setNumCompteDepart(String numCompteDepart) {
		this.numCompteDepart = numCompteDepart;
	}

	public String getNumCompteCible() {
		return numCompteCible;
	}

	public void setNumCompteCible(String numCompteCible) {
		this.numCompteCible = numCompteCible;
	}

	public BeanOperation() {

	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdcomptedepart() {
		return idCompteDepart;
	}

	public void setIdcomptedepart(int idcomptedepart) {
		this.idCompteDepart = idcomptedepart;
	}

	public int getIdcomptecible() {
		return idCompteCible;
	}

	public void setIdcomptecible(int idcomptecible) {
		this.idCompteCible = idcomptecible;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getTypeOper() {
		return typeoper;
	}

	public void setTypeOper(String type) {
		this.typeoper = type;
	}

	@Override
	public String toString() {
		return "BeanOperation [id=" + id + ", idclient=" + idclient + ", nomClient=" + nomClient + ", prenomClient="
				+ prenomClient + ", date=" + date + ", idCompteDepart=" + idCompteDepart + ", idCompteCible="
				+ idCompteCible + ", numCompteDepart=" + numCompteDepart + ", numCompteCible=" + numCompteCible
				+ ", montant=" + montant + ", etat=" + etat + ", typeoper=" + typeoper + "]";
	}

	public int getCritere() {
		return critere;
	}

	public void setCritere(int critere) {
		this.critere = critere;
	}

}
