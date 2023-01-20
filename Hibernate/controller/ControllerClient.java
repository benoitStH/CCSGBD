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
    	boolean exist = false;
    	int taille;
    	List<Client> clients = GetClientFromStore(magasin);
    	
    	System.out.println("Clients : "+clients.size());
    	
    	taille = clients.size();
    	for(int i = 0; i < taille && exist == false; i++)
    	{
    		exist = clients.get(i).equals(client);
    	}
    	
    	if(exist)
    	{
    		return null;
    	}
    	
    	
    	client.setStore(magasin);
    	
        manager.getTransaction().begin();
        manager.persist(client);
        manager.getTransaction().commit();
        if (manager.contains(client)) {
            return client;
        } else {
            return null;
        }
    }
    
    public List<Client> GetClientFromStore(Magasin store)
    {
    	List<Client> clients;
    	
    	Query query = manager.createQuery("From Client where magasin_id ="+store.getId());
    	
    	clients = query.getResultList();
    	
    	return clients;
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