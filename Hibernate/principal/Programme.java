package principal;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.ControllerCategorie;
import controller.ControllerClient;
import controller.ControllerCommande;
import controller.ControllerComposant;
import controller.ControllerMagasin;
import controller.ControllerMateriaux;
import view.CategorieView;
import view.ClientView;
import view.CommandeView;
import view.ComposantView;
import view.MagasinView;
import view.MateriauxView;

public class Programme {

	private static ControllerCategorie categorieCtrl;
	private static ControllerClient clientCtrl;
	private static ControllerCommande commandeCtrl;
	private static ControllerComposant composantCtrl;
	private static ControllerMagasin magasinCtrl;
	private static ControllerMateriaux materiauxCtrl;
	
	private static CategorieView categorieV;
	private static ClientView clientV;
	private static CommandeView commandeV;
	private static ComposantView composantV;
	private static MagasinView magasinV;
	private static MateriauxView materiauxV;
	
	
	public static void main(String args[])
	{
		int choix = 0;
		Scanner scan = new Scanner(System.in);
		
		// Creation de EntityManager
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = managerFactory.createEntityManager();
		
		// Initialisation des controllers et views
		SetController(manager);
		SetView();
		
		
		do
		{
			System.out.println("1 - Select a shop");
			System.out.println("2 - Search a material");
			System.out.println("0 - Quit application");
			
			while(scan.hasNextInt() == false)
			{
				System.out.println("It must be a number between 0 and 6");
				choix = -1;
			}
			
			choix = scan.nextInt();
			
			switch(choix)
			{
				case 1:
					// Selection d'un magasin
					magasinV.SelectShop();
				break;
				
				case 2:
					// Recherche d'un materiel
					
				break;
				
				case 3:
					// 
				break;
				
				case 4:
					// 
				break;
				
				case 5:
					// 
				break;
				
				case 6:
					// 
					
				break;
				
				case 0:
					// Arrêt de l'application
					
				break;
				
				default:
					break;
			}
			
		}while(choix != 0);
		
		manager.close();
		
		
	}
	
	public static void SetController(EntityManager manager)
	{
		categorieCtrl = new ControllerCategorie(manager);
		clientCtrl = new ControllerClient(manager);
		commandeCtrl = new ControllerCommande(manager);
		composantCtrl = new ControllerComposant(manager);
		magasinCtrl = new ControllerMagasin(manager);
		materiauxCtrl = new ControllerMateriaux(manager);
	}
	
	public static void SetView()
	{
		categorieV = new CategorieView(categorieCtrl);
		clientV = new ClientView(clientCtrl);
		commandeV = new CommandeView(commandeCtrl);
		composantV = new ComposantView(composantCtrl);
		magasinV = new MagasinView(magasinCtrl);
		materiauxV = new MateriauxView(materiauxCtrl);
	}
}
