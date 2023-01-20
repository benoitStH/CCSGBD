package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.*;

public class ControllerMagasin extends ControllerEntity {

	private Magasin magasin;

    public ControllerMagasin() {
        super();
    }

    public ControllerMagasin(EntityManager manager) {
        super(manager);
    }
    
    

    public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
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
    
    public List<Commande> GetCommandeMagasin(Magasin store)
    {
    	List<Commande> commandes = new ArrayList<Commande>();
    	List<Commande> commandesMagasin = new ArrayList<Commande>();
    	List<Client> clients = GetClientMagasin(store);
    	Query query;
    	int taille1, taille2;
    	
    	taille1 = clients.size();
    	for(int i = 0; i < taille1; i++)
    	{
    		// Récupération des commandes de chaque client i
    		query = manager.createQuery("From Commande where client_id = "+clients.get(i).getId());
    		commandes = query.getResultList();
    		
    		taille2 = commandes.size();
    		for(int j = 0; j < taille2; j++)
    		{
    			// Ajout dans la liste de commandes totales du magasin
    			commandesMagasin.add(commandes.get(j));
    		}
    	}
    	
    	return commandesMagasin;
    	
    }

    public Seuil SetSeuilForClient(Magasin store, Client client, int quantiteMax ,String categorieName)
    {

        Seuil seuil = new Seuil();
        seuil.setClient(client);
        seuil.setQuantiteMax(quantiteMax);
        Categorie categorie = new Categorie();
        categorie.setNom(categorieName);
       /* if(manager.find(Categorie.class,categorie.getId()) == null)
        {
            return null;
        }*/
        seuil.setCategorie(categorie);

        manager.getTransaction().begin();
        manager.persist(seuil);
        manager.getTransaction().commit();
        if (manager.contains(seuil)) {
            return seuil;
        } else {
            return null;
        }

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
        Magasin magasin = new Magasin();
        magasin.setNom(name);
        magasin.setClientele(null);
        
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