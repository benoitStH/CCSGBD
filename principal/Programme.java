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

public class Programme {

	public static void main(String args[])
	{
		ControllerCategorie CategCtrl = new ControllerCategorie();
		ControllerComposant ComposantCtrl = new ControllerComposant();
		ControllerMateriaux MateriauxCtrl = new ControllerMateriaux();
		/*
		ControllerClient ClientCtrl = new ControllerClient(); 
		ControllerCommande CommandCtrl = new ControllerCommande();
		ControllerComposant ComposantCtrl = new ControllerComposant();
		ControllerMagasin MagasinCtrl = new ControllerMagasin();
		*/
		
		ViewMagasin MagasinView = new ViewMagasin();
		
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
		
		int choix = -1;
		Scanner scan = new Scanner(System.in);
		
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
				MagasinView.ShowMagasins();
				MateriauxView.ShowMateriauxFrom(MagasinView.SelectMagasin().getMateriaux());
				
			}
			else if(choix == 2)
			{
				
			}
			else if(choix == 3)
			{
				
			}
		}
		
		
		
		// Fermeture de connexion
		try
		{
			c.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur d'ouverture de connexion");
			System.exit(1);
		}
		
		
		
	}
	
}
