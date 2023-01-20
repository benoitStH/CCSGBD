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

        if(recherche.isEmpty())
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
        if(FindCategorieByName(nom) != null)
        {
            return null;
        }
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

    public Categorie DeleteCategorie(Categorie categorie)
    {
        Categorie toDelete = FindCategorieByName(categorie.getNom());
        if(toDelete.equals(categorie))
        {
            manager.getTransaction().begin();
            manager.remove(toDelete);
            manager.getTransaction().commit();
        }

        return null;
    }

    public Categorie UpdateCategorieName(Categorie categorie, String newName)
    {
        Categorie toChange = FindCategorieByName(categorie.getNom());
        if(toChange.equals(categorie) && toChange != null)
        {
            toChange.setNom(newName);
            manager.getTransaction().begin();
            manager.merge(toChange);
            manager.getTransaction().commit();
        }

        if (manager.contains(toChange))
        {
            return toChange;
        }
        else
        {
            return null;
        }

    }





}