package org.formation.spring.entity;

import java.util.Vector;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Entity carte bancaire
 * @author NTH
 *
 */
@Entity
@Table(name = "carte")
@DiscriminatorColumn(name = "carte_type", discriminatorType = DiscriminatorType.STRING)
public abstract class  CarteBancaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String numeroCarte;
	@OneToOne
	private CompteCourant compteCourant;
	public CarteBancaire(String numero) {
		this.numeroCarte= numero;
	}
	
	
	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numero) {
		this.numeroCarte=numero;
	}

}