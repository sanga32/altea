package univ.lille1.miage.m2.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import univ.lille1.miage.m2.bean.Catalogue;
import univ.lille1.miage.m2.bean.ListingEmprunteur;
import univ.lille1.miage.m2.bean.Livre;

public class MetierCatalogue {

	public static final String CTX_ATTRIBUT_CATALOGUE = "CATALOGUE";
	
	public static Catalogue getCatalogue(){
		// TODO A compl�ter
		ServletContext context = 
			      (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext() ;
		return (Catalogue)context.getAttribute(CTX_ATTRIBUT_CATALOGUE);
	}
	
	public static List<Livre> getLivreEmprunte(String login){
		
		// TODO A compl�ter
		Catalogue c = getCatalogue();
		List<Livre> l = c.getListeLivre();
		List<Livre> res = new ArrayList<Livre>() ;
		
		for( Livre log : l){
			if( log.getEmprunteur() != null && log.getEmprunteur().equals(login)){
				res.add(log);
			}
		}
		
		return res;
		
	}

	public static List<Livre> getLivreNonEmprunte(){
		// TODO A compl�ter
		ArrayList<Livre> livres = (ArrayList<Livre>) getCatalogue().getListeLivre();
		ArrayList<Livre> result = new ArrayList<>();
		for (Livre livre : livres) {
			if (livre.getEmprunteur() == null || "".equals(livre.getEmprunteur())) {
				result.add(livre);
			}
		}
		return result;
	}
	
	

}
