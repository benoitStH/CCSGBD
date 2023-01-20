package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Categorie;
import model.Composant;
import model.Composition;
import model.Materiaux;

public class ControllerMateriaux extends ControllerEntity {

    public ControllerMateriaux() {
        super();
    }

    public ControllerMateriaux(EntityManager manager) {
        super(manager);
    }

    public List<Materiaux> GetMaterialByComponent(Composant component)
    {
    	int taille;
    	List<Composition> composition = new ArrayList<Composition>();
    	List<Materiaux> materiauxList = new ArrayList<Materiaux>();
        Query query = manager.createQuery("FROM Composition where composant_id = "+component.getId());

        composition = query.getResultList();
        taille = composition.size();        
        
        // Récupération du materiel associé à la composition i
        for(int i = 0; i < taille; i++)
        {
        	// On ne récupère pas les doublons
        	if(materiauxList.contains(composition.get(i).getMateriaux()) == false)
        	{
            	materiauxList.add(composition.get(i).getMateriaux());
        	}
        }
        
        return materiauxList;
    }

    public List<Materiaux> GetMaterialByName(String nom)
    {
    	List<Materiaux> materiauxList = new ArrayList<Materiaux>();
        Query query = manager.createQuery("FROM Materiaux where nom like '%"+nom+"%'");

        materiauxList = query.getResultList();
        
        return materiauxList;
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





}