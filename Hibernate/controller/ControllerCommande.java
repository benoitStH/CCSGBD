package controller;

import model.Commande;
import model.Panier;

import javax.persistence.EntityManager;
import java.util.List;

public class ControllerCommande extends ControllerEntity {

    public ControllerCommande() {
        super();
    }

    public ControllerCommande(EntityManager manager) {
        super(manager);
    }

    public Commande CreateCommande(Commande commande, List<Panier> panierList)
    {
        manager.getTransaction().begin();
        manager.persist(commande);
        for(Panier i : panierList)
        {
            if(manager.contains(i) == false)
            {
                manager.persist(i);
            }
        }
        manager.getTransaction().commit();

        if (manager.contains(commande)) {
            return commande;
        } else {
            return null;
        }
    }

}