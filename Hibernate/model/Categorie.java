package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie extends Information {

    @OneToMany(cascade = CascadeType.ALL)
    List<Materiaux> listMat;

    public List<Materiaux> getListMat() {
        return listMat;
    }

    public Categorie(String nom, List<Materiaux> listMat) {
        super(nom);
        this.listMat = listMat;
    }

    public Categorie()
    {
        super();
    }

    public void setListMat(List<Materiaux> listMat) {
        this.listMat = listMat;
    }

    public boolean equals(Categorie other)
    {
        return equals((Information)other);   
    }

}
