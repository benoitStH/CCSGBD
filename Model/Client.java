package Model;

import java.util.List;
import java.util.ArrayList;

public class Client extends Entity {


	private String prenom;

	private List<Integer> seuilMax;

	private List<Categorie> listCat;
	

	public Client(int id, String nom, String prenom, List<Integer> seuilMax, List<Categorie> listCat) {
		super(id, nom);
		this.prenom = prenom;
		this.seuilMax = seuilMax;
		this.listCat = listCat;
	}

	
	public String getPrenom() {
		return prenom;
	}

	public List<Integer> getSeuilMax() {
		return seuilMax;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSeuilMax(List<Integer> seuilMax) {
		this.seuilMax = seuilMax;
	}

	public List<Categorie> getListCat() {
		return listCat;
	}

	public void setListMag(List<Magasin> listMag) {
		this.listCat = listCat;
	}

	@Override
	public String toString() {
		return "Client{" +
				"prenom='" + prenom + '\'' +
				", seuilMax=" + seuilMax +
				", listCat=" + listCat +
				'}';
	}
}
