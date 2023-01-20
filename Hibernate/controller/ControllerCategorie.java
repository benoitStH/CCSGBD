package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Categorie;
import model.Magasin;

public class ControllerCategorie extends ControllerEntity {

    public ControllerCategorie() {
        super();
    }

    public ControllerCategorie(EntityManager manager) {
        super(manager);
    }
    
    public List<Categorie> GetCategorieFromStore(Magasin store)
    {
    	List<Categorie> categories;
    	Query query = manager.createQuery("From categorie");
    	
    	categories = query.getResultList();
    	
    	return categories;
    	
    }

    public Categorie CreateCategorie(String nom)
    {
        Categorie categorie = new Categorie();
        categorie.setNom(nom);

        manager.getTransaction().begin();
        manager.persist(categorie);
        manager.getTransaction().commit();

        // Retourne l'élément enregistré sinon retourne null en cas d'erreur
        if (manager.contains(categorie)) {
            return categorie;
        } else {
            return null;
        }
    }

    



}