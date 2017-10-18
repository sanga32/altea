package univ.lille1.miage.m2.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.service.MetierPersonnes;


@ManagedBean (name="login")
@SessionScoped
public class Login implements Serializable {

	private String login;
	private String password;
	
	public Login() {
	
	}

	public String getlogin() {
		return login;
	}

	public void setlogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validate(String password, String login) {
		Personne personne = MetierPersonnes.getPersonne(this.login, this.password);
		if (personne == null) {
			return "error";
		}
		return "success";
	}

	public Personne getPersonne() {
		Personne personne = MetierPersonnes.getPersonne(this.login, this.password);
		if (personne != null) {
			return personne;
		}
		return null;
	}

}
