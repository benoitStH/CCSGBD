package Dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import Model.Client;
import Model.Commande;
import Model.Materiaux;
import utility.Utility;

public class CommandeDAO extends SuperDAO{
	
	public CommandeDAO()
	{
		super("commande");
	}
	
	public Commande getElementById(int value)
	{

		Commande commande = null;
		//Liste de quantité
		List<Integer> listQ = new ArrayList();
		//Liste de materiaux
		List<Materiaux> listMat = new ArrayList();
		int id = 0;
		ResultSet rs = getElementById("idCom",value);
		{
			try {

				while (rs.next())
				{
					//Recuperation de l'id de la commande
					id = rs.getInt(1);
					//Requete SQL pour recuperer la liste des materiaux dans la commande


				}

				commande = new Commande(id,listQ,listMat);
			} catch (SQLException e) {
				System.out.println("Erreur while generating object" + "\n");
			}try {
				Statement stmt = Utility.initConnexion().createStatement();
				String sql = "SELECT * FROM panier WHERE idCom =" + id + ";";
				ResultSet rSet = stmt.executeQuery(sql);
				while(rSet.next())
				{
					//Recuperation de la quantité et affectation dans la liste
					int qt = rSet.getInt(3);
					listQ.add(qt);
					//Recuperation du materiaux de la commande et affectation dans sa liste
					MateriauxDAO daoMat = new MateriauxDAO();
					listMat.add(daoMat.getElementById(rSet.getInt(1)));
				}


					commande = new Commande(id,listQ,listMat);
			} catch (SQLException e) {
				System.out.println("Erreur while generating object 2" + "\n");
			}

		}



		return commande;
	}

	public List<Commande> getCommandes()
	{
		List<Commande> listCom = new ArrayList<>();
		try{
			Statement stmt = Utility.initConnexion().createStatement();
			String sql = "SELECT * FROM commande";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				listCom.add(getElementById(rs.getInt(1)));
			}
		}catch(SQLException sqlE)
		{
			System.out.println("Erreur");
			sqlE.printStackTrace();
		}

		return listCom;
	}

}
