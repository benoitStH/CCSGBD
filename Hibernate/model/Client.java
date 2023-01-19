package model;

import javax.persistence.*;

@Entity
public class Client extends Information {

    private String prenom;

    @OneToOne(cascade = CascadeType.ALL)
    private Magasin magasin;

    public Client()
    {
        super();
    }

    public Client(String prenom, Magasin store) {
        this.prenom = prenom;
        this.magasin = store;
    }

    public Client(String nom, String prenom, Magasin store) {
        super(nom);
        this.prenom = prenom;
        this.magasin = store;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Magasin getStore() {
        return magasin;
    }

    public void setStore(Magasin store) {
        this.magasin = store;
    }
    
    public boolean equals(Client other)
    {
        return ((prenom == other.prenom) && equals((Information)other));
    }

    @Override
    public String toString() {
        return "Client First Name: " + this.getPrenom() +" | Client Last Name: " + this.getNom() + " | Client Id (" + this.getId() + ") | Associated Store : " + this.getStore().getNom() +"\n";
    }
}
