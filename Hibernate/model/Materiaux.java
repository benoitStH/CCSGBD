package model;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Materiaux extends Information {


    @Embedded
    private Materiaux substitue;

    @OneToOne(cascade = CascadeType.ALL)
    private Categorie categorie;

    public Materiaux(int id, String nom, Materiaux substitue, Categorie categorie) {
        super(id, nom);
        this.substitue = substitue;
        this.categorie = categorie;
    }

    public Materiaux getSubstitue() {
        return substitue;
    }

    public void setSubstitue(Materiaux substitue) {
        this.substitue = substitue;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}