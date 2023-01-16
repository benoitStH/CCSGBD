package model;



import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Magasin extends Information {


@OneToMany(cascade = CascadeType.ALL)
List<Client> clientele;

    public Magasin(int id, String nom, List<Client> clientele) {
        super(id, nom);
        this.clientele = clientele;
    }

    public List<Client> getClientele() {
        return clientele;
    }

    public void setClientele(List<Client> clientele) {
        this.clientele = clientele;
    }
}