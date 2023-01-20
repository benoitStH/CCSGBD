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


    public Magasin CreateMagasin(String name)
    {
        Query query = manager.createQuery("from Magasin where nom = '" + name +"'");
        if(query.getResultList().isEmpty() == false)
        {
            return null;
        }
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

    public Client SetClientToMagasin(Magasin magasin, Client client)
    {

        Client acheteur = manager.find(Client.class, client.getId());
        if(acheteur == null)
        {
            return null;
        }else
        {
            Magasin store  = manager.find(Magasin.class,magasin.getId());
            if(store == null)
            {
                return null;
            }
            acheteur.setStore(store);
            manager.getTransaction().begin();
            manager.merge(acheteur);
            manager.getTransaction().commit();
        }

        if (manager.contains(client)) {
            return null;
        } else {
            return client;
        }
    }

    public Stock AddStock(Stock stock)
    {
        Stock inventaire = new Stock();
        Magasin store = manager.find(Magasin.class,stock.getMagasin().getId());
        Materiaux materiaux = manager.find(Materiaux.class,stock.getMateriaux().getId());

        if(store == null || materiaux ==null)
        {
            return null;
        }

        inventaire.setMagasin(store);
        inventaire.setMateriaux(materiaux);
        inventaire.setQuantite(stock.getQuantite());

        manager.getTransaction().begin();
        manager.persist(inventaire);
        manager.getTransaction().commit();

        if(manager.contains(inventaire))
        {
            return inventaire;
        }else
        {
            return null;
        }
    }

    public Magasin DeleteMagasin(Magasin magasin)
    {
        Magasin MagToDelete = manager.find(Magasin.class, magasin.getId());
        manager.getTransaction().begin();
        manager.remove(MagToDelete);
        manager.getTransaction().commit();

        if (manager.contains(MagToDelete)) {
            return MagToDelete;
        } else {
            return null;
        }
    }














}