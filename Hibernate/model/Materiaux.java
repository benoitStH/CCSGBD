package model;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Materiaux extends Information {



    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Materiaux substitue;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Categorie categorie;

    public Materiaux(String nom, Materiaux substitue, Categorie categorie) {
        super(nom);
        this.substitue = substitue;
        this.categorie = categorie;
    }

    public Materiaux()
    {
        super();
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Materiaux{" +
                " | categorie = " + categorie.getNom() +
                " | < substitue = " + substitue +
                "> }";
    }
}