package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.*;
import org.jetbrains.annotations.NotNull;

public class ControllerMagasin extends ControllerEntity {



    public ControllerMagasin() {
        super();
    }

    public ControllerMagasin(EntityManager manager) {
        super(manager);
    }

    public List<Magasin> GetAll()
    {
        Query query = manager.createQuery("from Magasin");
        List<Magasin> list = query.getResultList();
        return list;
    }

    public List<Stock> GetStockMagasin( Magasin store)
    {
        Query query = manager.createQuery("FROM Stock where magasin_id  = " + store.getId() );

        List<Stock> list = query.getResultList();

        return list;
    }

    public List<Client> GetClientMagasin(Magasin store)
    {
        Query query = manager.createQuery("from Client where magasin_id = " + store.getId());
        List<Client> list = query.getResultList();

        return list;
    }

    public Magasin SetSeuilForClient(Magasin store, Client client, int quantiteMax ,String categorieName)
    {

        Seuil seuil = new Seuil();
        seuil.setClient(client);
        seuil.setQuantiteMax(quantiteMax);
        Categorie categorie = new Categorie(categorieName, null);
        if(manager.find(Categorie.class,categorie.getNom()) == null)
        {
            return null;
        }
        seuil.setCategorie(categorie);

        manager.getTransaction().begin();
        manager.persist(seuil);
        manager.getTransaction().commit();

        return null;
    }

    /*public List<Commande> GetCommandeMagasin(Magasin store)
    {
        Query query = manager.createQuery("SELECT DISTINCT * FROM commande INNER JOIN client on commande.client_id = client.id\n" +
                "WHERE client.magasin_id = 1; " + store.getId());
        List<Commande> list = query.getResultList();

        return list;
    }*/

    /**
     * Bon
     * @param name
     * @return
     */
    public Magasin CreateMagasin(String name)
    {
        Magasin magasin = new Magasin(name,null);
        manager.getTransaction().begin();
        manager.persist(magasin);
        manager.getTransaction().commit();

        if (manager.contains(magasin)) {
            return magasin;
        } else {
            return null;
        }
    }

    public Stock AddStock(Stock stock)
    {
        manager.getTransaction().begin();
        manager.persist(stock);
        manager.getTransaction().commit();

        if(manager.contains(stock))
        {
            return stock;
        }else
        {
            return null;
        }
    }














}