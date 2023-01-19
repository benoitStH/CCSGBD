package model;

import javax.persistence.*;


@MappedSuperclass
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    public Information()
    {

    }
    public Information( String nom) {
        super();
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