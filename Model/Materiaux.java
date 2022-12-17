package Model;


public class Materiaux extends Entity {

	private Materiaux substitue;

	
	

	public Materiaux(int id, String nom, Materiaux substitue) {
		super(id, nom);
		this.substitue = substitue;
	}

	public Materiaux getSubstitue() {
		return substitue;
	}

	public void setSubstitue(Materiaux substitue) {
		this.substitue = substitue;
	}

	public String toString() {
		return "Materiaux{" + getId() + " " + getNom() + " "+
				"substitue= " + substitue +
				'}';
	}
}
