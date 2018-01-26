package org.formation.spring.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * entity abstract employe (strategy TABLE PER CLASS)
 * @author HS
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String login;
	private String pwd;
	
	/**
	 * 
	 */
	public Employe() {
		super();
	}

	/**
	 * @param login
	 * @param pwd
	 */
	public Employe(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employe [login=" + login + ", pwd=" + pwd + "]";
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
	
	
	
}
