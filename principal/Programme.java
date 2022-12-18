package principal;

import java.util.Scanner;

import View.ViewMagasin;
import View.ViewMateriaux;
import View.ViewComposant;
import View.ViewClient;
import View.ViewCommande;

public class Programme {

	public static void main(String args[])
	{	
		ViewMagasin magasinView = new ViewMagasin();
		ViewMateriaux materiauxView = new ViewMateriaux();
		ViewComposant composantView = new ViewComposant();
		ViewClient clientView = new ViewClient();
		ViewCommande commandeView = new ViewCommande();
		
		int choix = -1;
		Scanner scan = new Scanner(System.in);
		Magasin magasin;
		Composant composant;
		
		// PROGRAMME PRINCIPAL //
		while(choix != 0)
		{
			System.out.println("1 - Afficher le contenu d'un magasin");
			System.out.println("2 - Créer une commande cliente");
			System.out.println("3 - Rechercher des matériaux à partir d'un composant");
			System.out.println("0 - Quitter l'application");
			
			System.out.prints("Veuillez saisir une option : ");
			
			choix = scan.nextInt();
			 
			if(choix == 1)
			{
				// choix d'un magasin parmi ceux existants
				magasinView.ShowMagasins();
				magasin = magasinView.SelectMagasin();
				
				// Affichage des materiaux du magasin selectionné
				materiauxView.ShowMateriauxFrom(magasin.getMateriaux());
				
				// Recherche dans le contenu du magasin
				magasinView.InspectMagasin(magasin);
				
			}
			else if(choix == 2)
			{
				// choix d'un magasin parmi ceux existants
				magasinView.ShowMagasins();
				magasin = magasinView.SelectMagasin();
				
				// Ajout d'une commande
				commandeView.AddCommande(magasin);
				
			}
			else if(choix == 3)
			{
				// Choix d'un composant parmi ceux existant
				composantView.ShowComposants();
				composant = composantView.SelectComposant();
				
				// Affichage des matériaux ayant le composant seléctionné
				materiauxView.ShowMateriauxFrom(comp.getMateriaux());
			}
		}
		
		
		// Arrêt du programme
		System.out.println("Arrêt de l'application");
		
		
	}
	
}
