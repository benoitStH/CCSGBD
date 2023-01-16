package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Categorie extends Information {

    @OneToMany(cascade = CascadeType.ALL)
    List<Materiaux> listMat;

    public List<Materiaux> getListMat() {
        return listMat;
    }

    public Categorie(int id, String nom, List<Materiaux> listMat) {
        super(id, nom);
        this.listMat = listMat;
    }

    public void setListMat(List<Materiaux> listMat) {
        this.listMat = listMat;


    }
}