package Model;

import java.util.List;

public class Categorie extends Entity {

	List<Materiaux> listMat;

	@Override
	public String toString() {
		return "Categorie{" + getId() + " " + getNom() + " " +  "listMat=" + listMat + '}';
	}

	public Categorie(int id, String nom, List<Materiaux> listMat) {
		super(id, nom);
		this.listMat = listMat;
	}

	public List<Materiaux> getListMat() {
		return listMat;
	}

	public void setListMat(List<Materiaux> listMat) {
		this.listMat = listMat;
	}
}
