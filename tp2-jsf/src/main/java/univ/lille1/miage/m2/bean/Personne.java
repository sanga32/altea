package univ.lille1.miage.m2.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

public class Personne {
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private boolean droitImage;
	private Date dateDeNaissance;
	private int civilite;
	private int age;

	public int getAge() {
		
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCivilite() {
		return civilite;
	}

	public void setCivilite(int civilite) {
		this.civilite = civilite;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Personne(String login2, String password2) {
		// TODO Auto-generated constructor stub
		this.login = login2;
		this.password = password2;
	}

	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public boolean getDroitImage() {
		return droitImage;
	}

	public void setDroitImage(boolean droitImage) {
		this.droitImage = droitImage;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
