package Model;
import java.util.List;
import java.util.ArrayList;

public class Composant extends Entity {

	private List<Materiaux> materiaux;

	public Composant(int id, String nom, List<Materiaux> materiaux) {
		super(id, nom);
		this.materiaux = materiaux;
	}

	public List<Materiaux> getMateriaux() {
		return materiaux;
	}

	public void setMateriaux(List<Materiaux> materiaux) {
		this.materiaux = materiaux;
	}

	

	

}
