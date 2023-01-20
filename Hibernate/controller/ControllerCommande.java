package controller;

import model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ControllerCommande extends ControllerEntity {

    private Client client;

    public ControllerCommande() {
        super();
    }

    public ControllerCommande(EntityManager manager) {
        super(manager);
    }

    public Commande CreateCommande(Client client, List<Panier> panierList)
    {
        Commande commande = new Commande();
        Client acheteur = manager.find(Client.class,client.getId());
        commande.setClient(acheteur);

        manager.getTransaction().begin();
        manager.persist(commande);
        manager.getTransaction().commit();

        if(panierList.isEmpty() == false)
        {
            for(Panier i : panierList)
            {
                if(manager.find(Panier.class,i.getId()) == null)
                {
                    i.setCommande(commande);
                    Materiaux materiaux = manager.find(Materiaux.class,i.getMateriaux().getId());
                    if( materiaux != null )
                    {
                        i.setMateriaux(materiaux);
                        manager.getTransaction().begin();
                        manager.merge(i);
                        manager.getTransaction().commit();
                    }

                }
            }
        }

        if (manager.contains(commande)) {
            return commande;
        } else {
            return null;
        }
    }

    public List<Panier> AddPanierCommande(Commande commande, List<Panier> panierList)
    {
        Commande command = manager.find(Commande.class,commande.getId());
        if(command == null)
        {
            return null;
        }
        List<Panier> panierCreated = new ArrayList<>();
        if(panierList.isEmpty() == false)
        {
            for(Panier i : panierList)
            {
                if(manager.find(Panier.class,i.getId()) == null)
                {
                    i.setCommande(command);
                    Materiaux materiaux = manager.find(Materiaux.class,i.getMateriaux().getId());
                    if( materiaux != null )
                    {
                        i.setMateriaux(materiaux);
                        manager.getTransaction().begin();
                        manager.merge(i);
                        manager.getTransaction().commit();
                    }

                }
            }
        }

        for(Panier i : panierList)
        {
            if(manager.contains(i))
            {
                panierCreated.add(i);
            }
        }

        return panierCreated;
    }

    public List<Commande> GetCommandesOfClient(Client acheteur)
    {
        Client client = manager.find(Client.class,acheteur.getId());
        Query query = manager.createQuery("from Commande where client_id = " + client.getId());
        List<Commande> listCommande = query.getResultList();

        return listCommande;
    }

    public Commande GetCommandeById(int id)
    {
        Query query = manager.createQuery("from Commande where id = " + id);
        List<Commande> listCommande = query.getResultList();

        if(listCommande.isEmpty())
        {
            return null;
        }else
        {
            return listCommande.get(0);
        }

    }



}