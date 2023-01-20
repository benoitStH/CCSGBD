package controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Categorie;
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

    public Client FindClientByName(String name)
    {

        Query query = manager.createQuery("from Client where nom = '"+ name + "'");
        List<Client> recherche = query.getResultList();

        if(recherche.isEmpty())
        {
            return null;
        }
        else
        {
            return recherche.get(0);
        }

    }

    public List<Client> FindListClientByName(String name)
    {

        Query query = manager.createQuery("from Client where nom = '"+ name + "'");
        List<Client> recherche = query.getResultList();

        if(recherche.isEmpty())
        {
            return null;
        }
        else
        {
            return recherche;
        }

    }

    public Client CreateClient(Client client, Magasin magasin)
    {
           ControllerMagasin controllerMagasin =new ControllerMagasin(manager);
            Magasin store = controllerMagasin.FindMagasinByName(magasin.getNom());
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
        Client cli = FindClientByName(client.getNom());
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
        Client acheteur = FindClientByName(client.getNom());
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
            Magasin store = new ControllerMagasin(manager).FindMagasinByName(magasin.getNom());
            acheteur.setStore(store);
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

    public Seuil SetSeuilForClient(Client client, int quantiteMax , Categorie categorie)
    {

        Client acheteur = FindClientByName(client.getNom());
        Categorie groupe = new ControllerCategorie(manager).FindCategorieByName(categorie.getNom());
        if(acheteur == null || groupe == null)
        {
            return null;
        }

        Seuil seuil = new Seuil();
        seuil.setClient(acheteur);
        seuil.setQuantiteMax(quantiteMax);
        seuil.setCategorie(groupe);

        manager.getTransaction().begin();
        manager.persist(seuil);
        manager.getTransaction().commit();
        if (manager.contains(seuil)) {
            return seuil;
        } else {
            return null;
        }

    }


}