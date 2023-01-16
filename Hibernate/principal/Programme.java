package principal;

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
import view.EntityView;
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
		// Creation de EntityManager
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = managerFactory.createEntityManager();
		
		// Initialisation des controllers et views
		SetController(manager);
		SetView();
		
		
		
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
