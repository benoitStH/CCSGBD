package model;

import javax.persistence.*;

@Entity
public class Seuil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categorie categorie;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    private int quantiteMax;
    public Seuil()
    {

    }



    public Seuil(int id, Categorie categorie, Client client, int quantiteMax) {
        this.id = id;
        this.categorie = categorie;
        this.client = client;
        this.quantiteMax = quantiteMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getQuantiteMax() {
        return quantiteMax;
    }

    public void setQuantiteMax(int quantiteMax) {
        this.quantiteMax = quantiteMax;
    }
}
