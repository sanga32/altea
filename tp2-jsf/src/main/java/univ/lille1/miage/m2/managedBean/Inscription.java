package univ.lille1.miage.m2.managedBean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.service.MetierPersonnes;

@ManagedBean(name = "inscription")
@SessionScoped
public class Inscription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String login;
	private String motDePasse;
	private boolean droitImage;
	private Date dateDeNaissance;
	private int civilite;
	private int age;

	public int getCivilite() {
		return civilite;
	}

	public int getAge(){
		if ( dateDeNaissance != null ){
			Date d = new Date();
			int res = d.getYear() - dateDeNaissance.getYear();

			if( d.getMonth() > dateDeNaissance.getYear()){
				res = res - 1;
			}
			age = res;
			System.out.println("AGE : "+age);
		}
		return age;

	}

	public void setCivilite(int civilite) {
		this.civilite = civilite;
	}

	public Date getdateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public boolean getDroitImage() {
		return droitImage;
	}

	public void setDroitImage(boolean droitImage) {
		this.droitImage = droitImage;
	}

	public Inscription() {

	}

	public String signUp() {
		MetierPersonnes.addPersonne(login, motDePasse, nom, prenom, droitImage, dateDeNaissance, civilite, age);
		return "login";
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
