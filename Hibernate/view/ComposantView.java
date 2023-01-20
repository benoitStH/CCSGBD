package view;

import java.util.List;

import controller.ControllerComposant;
import controller.ControllerEntity;
import model.Composant;

public class ComposantView extends EntityView {

	private ControllerComposant Ctrl;
	
	public ComposantView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerComposant) controller;
	}
	
	
	public Composant SelectComponent()
	{
		Integer choix;
		String nom;
		List<Composant> components = Ctrl.GetAll();
		
		
		if(components == null || components.size() == 0)
		{
			System.out.println("Aucun composant existant");
			System.out.println("Retour à la page précédente");
			return null;
		}
		
		
		// Affichage des composants existants
		Show(components);
		
		// Selection du composant
		choix = getInputInt("Numero du composant voulu : ");
		
		if(choix == null || choix < 1 || choix > components.size())
		{
			System.out.println("Aucun magasin sélectionné");
			System.out.println("Retour à la page précédente");
			return null;
		}
		
		
		return components.get(choix - 1);
		
	}
	
	public void Show(List<Composant> components)
	{

		int taille;
		
		if(components == null)
		{
			return;
		}
		
		taille = components.size();
		
		for(int i = 0; i < taille; i++)
		{
			System.out.println((i+1)+" - "+components.get(i).getNom());
		}
	}
	
}
