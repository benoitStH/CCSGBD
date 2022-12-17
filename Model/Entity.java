package Model;
public class Entity {

	private int id;

	private String nom;
	
	public Entity(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String toString() {
		return
				"id=" + id +
				", nom='" + nom + '\'' +
				'}';
	}
}
