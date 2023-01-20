package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Composant;

public class ControllerComposant extends ControllerEntity {

	public ControllerComposant() {
		super();
	}

	public ControllerComposant(EntityManager manager) {
		super(manager);
	}
	
	public List<Composant> GetAll()
	{
		// Add Def : Retourne tous les composants de la base
		List<Composant> composants = new ArrayList<Composant>();
        Query query = manager.createQuery("FROM Composant");

        composants = query.getResultList();
        
        return composants;
	}


}
