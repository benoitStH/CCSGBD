package model;



import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Magasin extends Information {


@OneToMany(cascade = CascadeType.ALL)
List<Client> clientele = null;

    public Magasin(String nom, List<Client> clientele) {
        super(nom);
        this.clientele = clientele;
    }

    public Magasin()
    {
        super();
    }

    public List<Client> getClientele() {
        return clientele;
    }

    public void setClientele(List<Client> clientele) {
        this.clientele = clientele;
    }

    @Override
    public String toString() {
        return (this.getNom()+ "[ Store ID : " + this.getId() +"] \n Clients : " + Arrays.toString(clientele.toArray()))  ;
    }
}