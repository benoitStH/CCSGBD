package Model;

import java.util.List;
import java.util.ArrayList;

public class Magasin extends Entity {

	private List<Integer> Stock;
	private List<Materiaux> materiaux;
	

	public Magasin(int id, String nom, List<Integer> listStock, List<Materiaux> listMat) {
		super(id, nom);
		Stock = listStock;
		this.materiaux = listMat;
	}

	public List<Integer> getStock() {
		return Stock;
	}

	public void setStock(List<Integer> stock) {
		Stock = stock;
	}

	public List<Materiaux> getMateriaux() {
		return materiaux;
	}

	public void setMateriaux(List<Materiaux> materiaux) {
		this.materiaux = materiaux;
	}

	@Override
	public String toString() {
		return "Magasin{" +
				"Stock=" + Stock +
				", materiaux=" + materiaux +
				'}';
	}
}
