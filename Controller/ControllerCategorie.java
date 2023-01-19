package controller;

import java.util.List;

import javax.persistence.EntityManager;

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

    public Categorie CreateCategorie(String nom, List<Materiaux> listMat)
    {
        Categorie categorie = new Categorie(nom,listMat);

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