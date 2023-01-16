package model;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Composant extends Information {

    @ManyToMany(cascade = CascadeType.ALL)
    List<Materiaux> materiaux;
    public Composant(int id, String nom) {
        super(id, nom);
    }


}