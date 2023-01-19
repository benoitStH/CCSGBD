package controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Client;
import model.Magasin;
import model.Seuil;
import java.util.List;

public class ControllerClient extends ControllerEntity {

    public ControllerClient() {
        super();
    }

    public ControllerClient(EntityManager manager) {
        super(manager);
    }

    public Client CreateClient(Client client, Magasin magasin)
    {
            Magasin store = manager.find(Magasin.class,magasin.getId());
            if(store == null)
            {
                return null;
            }
            client.setStore(store);
            manager.getTransaction().begin();
            manager.merge(client);
            manager.getTransaction().commit();
            if (manager.contains(client)) {
                return client;
            } else {
                return null;
            }
    }

    public Client DeleteClient(Client client)
    {
        Client cli = manager.find(Client.class, client.getId());
        //Seuil seuil = manager.find(Seuil.class,client.getId());
        Query query = manager.createQuery("from Seuil where client_id = " + client.getId());
        List<Seuil> seuil = query.getResultList();
        manager.getTransaction().begin();
        manager.remove(cli);
        for(Seuil i : seuil)
        {
            manager.remove(i);
        }
        manager.getTransaction().commit();

        if (manager.contains(cli)) {
           return cli;
        } else {
            return null;
        }
    }

    public Client UpdateClient(Client client, String name, String prenom, Magasin magasin)
    {
        Client acheteur = manager.find(Client.class, client.getId());
        if(name != null )
        {
            acheteur.setNom(name);
        }
        if(prenom != null)
        {
            acheteur.setPrenom(prenom);
        }
        if(magasin != null)
        {
            Magasin store = manager.find(Magasin.class,magasin.getId());
        }
        manager.getTransaction().begin();
        manager.merge(acheteur);
        manager.getTransaction().commit();

        if (manager.contains(acheteur)) {
            return acheteur;
        } else {
            return null;
        }
    }


}