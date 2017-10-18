package univ.lille1.miage.m2.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import univ.lille1.miage.m2.bean.ListingEmprunteur;
import univ.lille1.miage.m2.bean.Personne;
import univ.lille1.miage.m2.listener.StartupServletListener;

public class MetierPersonnes {
	
	
	public static final String CTX_ATTRIBUT_LISTING = "LISTING";
	private static ListingEmprunteur listePersonne ;
	
	/**
	 * R�cup�ration de la liste des emprunteur. 
	 * Cette liste est initialis�e au d�marrage de l'application
	 * @see StartupServletListener
	 * @return {@link ListingEmprunteur}
	 */
	public static ListingEmprunteur getPersonnes() {
		ServletContext context = 
			      (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext() ;
		return (ListingEmprunteur)context.getAttribute(CTX_ATTRIBUT_LISTING);
	}
	
	public static Personne getPersonne(String login, String password){
		
		ListingEmprunteur listePersonne = getPersonnes();
		Map map = listePersonne.getListePersonne();
		String c = login + "" + password;
		
		return (Personne) map.get(c);
		
/*		Set cles = map.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()){
		   String cle = (String) it.next(); // tu peux typer plus finement ici
		   Personne valeur = (Personne) map.get(cle); // tu peux typer plus finement ici
		   if ( valeur.getLogin().equals(login) && valeur.getPassword().equals(password)){
			   return valeur;
		   }
		
		}
		
		return new Personne(login, password);*/
	}

	public static void addPersonne(String login, String motDePasse, String nom, String prenom, boolean droitImage, Date dateDeNaissance, int civilite, int age) {
		// TODO Auto-generated method stub
		Personne newPersonne = new Personne();
	    newPersonne.setLogin(login);
	    newPersonne.setNom(nom);
	    newPersonne.setPassword(motDePasse);
	    newPersonne.setPrenom(prenom);
	    newPersonne.setDroitImage(droitImage);
	    newPersonne.setDateDeNaissance(dateDeNaissance);
	    newPersonne.setCivilite(civilite);
	    newPersonne.setAge(age);
	    getPersonnes().getListePersonne().put(login + motDePasse, newPersonne);
		
	}

	public static boolean loginExisteDeja(String login) {
		// TODO Auto-generated method stub
		Map<String, Personne> list = getPersonnes().getListePersonne();
		for (Personne personne : list.values()) {
			if (personne.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}

}
