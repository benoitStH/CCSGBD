package model;

import javax.persistence.*;

@Entity
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Composant composant;

    @ManyToOne(cascade = CascadeType.ALL)
    private Materiaux materiaux;

    private int quantite;

    public Composition()
    {

    }
    public Composition(int id, Composant composant, Materiaux materiaux, int quantite) {
        this.id = id;
        this.composant = composant;
        this.materiaux = materiaux;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Composant getComposant() {
        return composant;
    }

    public void setComposant(Composant composant) {
        this.composant = composant;
    }

    public Materiaux getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(Materiaux materiaux) {
        this.materiaux = materiaux;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
