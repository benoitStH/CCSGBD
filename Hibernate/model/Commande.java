package model;



import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private  Client client;

    public Commande(int id, Client client) {
        this.id = id;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}