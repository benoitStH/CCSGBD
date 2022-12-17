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
		
		
		System.out.println(CategCtrl.GetCategoryById(0).getNom());
		System.out.println(ComposantCtrl.GetComposantById(-1).getNom());
		System.out.println(MateriauxCtrl.getMateriauxById(1).getNom());
		
		
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
