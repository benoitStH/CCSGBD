package Model;

import java.util.List;

public class Commande {

	private int id;

	private List<Integer> quantite;
	private List<Materiaux> listMat;

	public Commande(int id, List<Integer> quantite, List<Materiaux> listMat) {
		this.id = id;
		this.quantite = quantite;
		this.listMat = listMat;
	}

	public List<Integer> getQuantite() {
		return quantite;
	}

	public void setQuantite(List<Integer> quantite) {
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Materiaux> getListMat() {
		return listMat;
	}

	public void setListMat(List<Materiaux> listMat) {
		this.listMat = listMat;
	}

	@Override
	public String toString() {
		return "Commande{" +
				"id=" + id +
				", quantite=" + quantite +
				", listMat=" + listMat +
				'}';
	}
}
