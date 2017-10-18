package univ.lille1.miage.m2.managedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import univ.lille1.miage.m2.bean.Livre;
import univ.lille1.miage.m2.bean.Login;
import univ.lille1.miage.m2.bean.Personne;
import univ.lille1.miage.m2.service.MetierCatalogue;

@ManagedBean (name="listeLivres")
@RequestScoped
public class ListeLivres {

	private HashMap <Long, Boolean> checked = new HashMap<>();
	private String login;

	public String emprunterLivres() {
		ArrayList<Livre> livres = (ArrayList<Livre>) MetierCatalogue.getCatalogue()
				.getListeLivre();
		for (Livre livre : livres) {
			if (checked.get(livre.getId()) != null && checked.get(livre.getId())) {
				livre.setEmprunteur(getLoginValue());	
			}
		}
		return "success";
	}


	public String getLoginValue() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Login login = (Login) facesContext.getExternalContext().getSessionMap().get("login");
		return login.getlogin();
	}

	/**
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return MetierCatalogue.getLivreNonEmprunte();
	}


	public HashMap<Long, Boolean> getChecked() {
		return checked;
	}


	public void setChecked(HashMap<Long, Boolean> checked) {
		this.checked = checked;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


}
