package univ.lille1.miage.m2.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="musician")
@RequestScoped
public class Musician {

	private String lastname;
	private String firstname;

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String bienvenue(){
		
		return "bienvenue";
	}
	
}
