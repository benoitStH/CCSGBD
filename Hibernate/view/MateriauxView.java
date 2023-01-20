package view;

import java.util.List;

import controller.ControllerEntity;
import controller.ControllerMateriaux;
import model.Composant;
import model.Materiaux;

public class MateriauxView extends EntityView {

	private ControllerMateriaux Ctrl;
	private ComposantView composantV;
	
	public MateriauxView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerMateriaux) controller;
	}
	
	public void SearchMaterial()
	{
		Integer choix;
		
		System.out.println("1 - Recherche par nom");
		System.out.println("2 - Recherche par composant");
		System.out.println("0 - Retour à la page précédente");
		
		choix = getInputUntilPositiveInt("Veuillez choisir le mode de recherche [0-2] : ");
		
		switch(choix)
		{
			case 1:
				// Recherche par nom
				SearchMaterialByName();
			break;
			
			case 2:
				// Recherche par composant
				SearchMaterialByComponent();
			break;
			
			case 0:
				// Retour
				System.out.println("Retour à la page précédente");
			break;
			
			default:
				// Retour
				System.out.println("Option "+choix+" inconnue");
				System.out.println("Retour à la page précédente");
			break;
		}
		
	}
	
	public void SearchMaterialByName()
	{
		String nom;
		List<Materiaux> materiaux;
		
		// Saisie du nom
		nom = getInputString("Nom du materiel : ");
		
		// Recherche de materiaux contenant le nom saisi
		materiaux = Ctrl.GetMaterialByName(nom);
		
		// Si aucun materiaux trouvés
		if(materiaux == null || materiaux.size() == 0)
		{
			System.out.println("Aucun materiaux ne correspond à '"+nom+"'");
			return;
		}
		
		// Affichage des materiaux trouvés
		Show(materiaux);
		System.out.println();
	}
	
	public void SearchMaterialByComponent()
	{
		String nom;
		Composant component;
		List<Materiaux> materiaux;
		
		component = composantV.SelectComponent();
		
		System.out.println(component.getId());
		
		if(component != null)
		{
			// Recherche de materiaux contenant composant choisi
			materiaux = Ctrl.GetMaterialByComponent(component);
			
			// Si aucun materiaux trouvés
			if(materiaux == null || materiaux.size() == 0)
			{
				System.out.println("Aucun materiel ne possède ce composant");
				System.out.println("Retour à la page précédente");
				return;
			}
			
			// Affichage des materiaux contenant le composant
			Show(materiaux);
			System.out.println();
		}
		
		
	}
	
	public void Show(List<Materiaux> materiaux)
	{

		int taille;
		
		if(materiaux == null)
		{
			return;
		}
		
		taille = materiaux.size();
		
		for(int i = 0; i < taille; i++)
		{
			System.out.println((i+1)+" - "+materiaux.get(i).getNom());
		}
	}
	
	public void setComposantView(ComposantView view)
	{
		composantV = view;
	}
}
