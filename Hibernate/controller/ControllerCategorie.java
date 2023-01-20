package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;

import model.Categorie;
import model.Materiaux;

public class ControllerCategorie extends ControllerEntity {

    public ControllerCategorie() {
        super();
    }

    public ControllerCategorie(EntityManager manager) {
        super(manager);
    }

    public Categorie FindCategorieByName(String name)
    {
        Query query = manager.createQuery("from Categorie where nom = '"+ name + "'");
        List<Categorie> recherche = query.getResultList();

        if(recherche == null)
        {
            return null;
        }
        else
        {
            return recherche.get(0);
        }
    }

    public Categorie CreateCategorie(String nom)
    {
        Categorie categorie = new Categorie(nom,null);

        manager.getTransaction().begin();
        manager.persist(categorie);
        manager.getTransaction().commit();

        if (manager.contains(categorie)) {
            return categorie;
        } else {
            return null;
        }
    }





}