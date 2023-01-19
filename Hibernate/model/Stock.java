package model;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Materiaux materiaux;

    @ManyToOne(cascade = CascadeType.ALL)
    private Magasin magasin;

    private int quantite;

    public Stock() {
    }

    public Stock(Materiaux materiaux, Magasin magasin, int quantite) {
        this.materiaux = materiaux;
        this.magasin = magasin;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Materiaux getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(Materiaux materiaux) {
        this.materiaux = materiaux;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "Id= (" + id +
                ") | Materiaux =" + materiaux +
                " | Magasin = " + magasin.getNom() +
                " | quantite = " + getQuantite() +
                "}\n";
    }
}
