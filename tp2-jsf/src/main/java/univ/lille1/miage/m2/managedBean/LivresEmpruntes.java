package univ.lille1.miage.m2.managedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import univ.lille1.miage.m2.bean.Livre;
import univ.lille1.miage.m2.bean.Login;
import univ.lille1.miage.m2.service.MetierCatalogue;


@ManagedBean(name = "livresEmpruntes")
@SessionScoped
public class LivresEmpruntes {

	private HashMap<Long, Boolean> checked = new HashMap<Long, Boolean>();
	private String login;
	
	public ArrayList<Livre> getLivresARendre() {
		return (ArrayList<Livre>) MetierCatalogue.getLivreEmprunte(getLogin());
	}
	
	public String getLoginValue() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Login login = (Login) facesContext.getExternalContext().getSessionMap().get("login");
		return login.getlogin();
	}

	public String rendreLivres() {
		List<Livre> livres = MetierCatalogue.getCatalogue().getListeLivre();
		for (Livre livre : livres) {
			if (checked.get(livre.getId()) != null && checked.get(livre.getId())) {
				livre.setEmprunteur(null);	
			}
		}
		return "success";
	}
	
	public HashMap<Long, Boolean> getChecked() {
		return checked;
	}

	public void setChecked(HashMap<Long, Boolean> checked) {
		this.checked = checked;
	}

	public String getLogin() {
		return getLoginValue();
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
