package univ.lille1.miage.m2.bean;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

	private List<Livre> listeLivre;

	public List<Livre> getListeLivre() {
		return listeLivre;
	}

	public void setListeLivre(List<Livre> listeLivre) {
		this.listeLivre = listeLivre;
	}

	public Catalogue() {
		super();
		this.listeLivre = new ArrayList<>();
	}

}
