package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import Controller.ControllerCategorie;
import Controller.ControllerClient;
import Controller.ControllerCommande;
import Controller.ControllerComposant;
import Controller.ControllerMagasin;
import Controller.ControllerMateriaux;

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
		
		Connection c = null;
		Properties user = new Properties();
		user.setProperty("user", "root");
		user.setProperty("password", "domadoma");
		
		
		// Chargement du Driver
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Erreur de Chargement du driver");
			System.exit(1);
		}
		
		// Ouverture de connexion
		try
		{
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybdd",
					user.getProperty("user"), user.getProperty("password"));
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur d'ouverture de connexion");
			System.exit(1);
		}
		
		// PROGRAMME PRINCIPAL //
		while(choix != 0)
		{
			System.out.println("1 - Afficher le contenu d'un magasin");
			System.out.println("2 - Créer une commande cliente");
			System.out.println("3 - Rechercher des matériaux à partir d'un composant");
			System.out.println("0 - Quitter l'application");
			
			System.out.print("Veuillez saisir une option : ");
			
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
		
		
		
		// Fermeture de connexion
		try
		{
			c.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur de fermeture de connexion");
			System.exit(1);
		}
		
		
		System.out.println("Arrêt de l'application");
		
		
	}
	
}
