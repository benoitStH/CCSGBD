package model;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Composant extends Information {

    @ManyToMany(cascade = CascadeType.ALL)
    List<Materiaux> materiaux;
    public Composant(String nom) {
        super(nom);
    }

    public Composant()
    {
        super();
    }

    public List<Materiaux> getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(List<Materiaux> materiaux) {
        this.materiaux = materiaux;
    }
}