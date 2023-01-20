package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ConstraintMode;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.*;

public class ControllerMateriaux extends ControllerEntity {

    public ControllerMateriaux() {
        super();
    }

    public ControllerMateriaux(EntityManager manager) {
        super(manager);
    }

    public List<Materiaux> GetMaterialByComponant(Composant component)
    {
       return null;
    }

    public List<Materiaux> GetMaterialByName(String nom)
    {
        return null;
    }

    public Materiaux CreateMateriaux(Materiaux materiaux) {
        manager.getTransaction().begin();
        manager.persist(materiaux);
        manager.getTransaction().commit();

        if (manager.contains(materiaux)) {
            return materiaux;
        } else {
            return null;
        }
    }
/*
    public List<Materiaux> GetMateriauxWithComposant(Composant composant)
    {
        List<Materiaux> materiauxList = new ArrayList();
        Query query = manager.createQuery("FROM materiaux LEFT OUTER JOIN composition on materiaux.id = composition.materiaux_id\n" +
                "WHERE composant_id = "+ composant.getId() );

        materiauxList = query.getResultList();


        return materiauxList;
    }*/

    public Materiaux CreateMateriaux(String nom, Materiaux substitue, Categorie categorie)
    {

        Materiaux materiaux = new Materiaux();
        materiaux.setCategorie(categorie);
        materiaux.setNom(nom);


        manager.getTransaction().begin();
        manager.persist(materiaux);
        manager.getTransaction().commit();

        if (manager.contains(materiaux)) {
            return materiaux;
        } else {
            return null;
        }
    }


    public Materiaux DeleteMateriaux(Materiaux materiaux)
    {
        Materiaux material = manager.find(Materiaux.class, materiaux.getId());
        if(material == null)
        {
            return null;
        }
        manager.getTransaction().begin();
        manager.remove(material);
        manager.getTransaction().commit();

        if (manager.contains(material)) {
            return material;
        } else {
            return null;
        }
    }

}