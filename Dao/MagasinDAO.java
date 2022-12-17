package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Magasin;
import Model.Materiaux;
import utility.Utility;

public class MagasinDAO extends SuperDAO{
	
	public MagasinDAO()
	{
		super("magasin");
	}
	
	public Magasin getElementById(int value)
	{
		List<Materiaux> listMat = new ArrayList();
		List<Integer> ListStock = new ArrayList();
		int id = 0;
		String nom = null;
		Magasin mag = null;
		
		ResultSet rs = getElementById("idMag",value);
	
		
		try {
			while(rs.next())
			{
				/*Recuperation d'ID d'un magasin*/
				id = rs.getInt(1);
				//Recuperation du nom d'un magasin
				nom = rs.getString(2);
			}
		} catch (SQLException e) {
			System.out.println("Unable to retrieve list" + "\n");
			e.printStackTrace();
		}try {
				Statement stmt = Utility.initConnexion().createStatement();
				//Requete SQL pour avoir le stock de chaque materiaux du magasin
				String sql = "SELECT * FROM stock WHERE idMag = " + id +";";
				ResultSet queryStock = stmt.executeQuery(sql);
				while(queryStock.next())
				{
					//Recuperation de l'id du materiaux
					int idMat = queryStock.getInt(1);
					//Creation d'un object Materiaux par rapport à id obtenu
					MateriauxDAO matDAO = new MateriauxDAO();
					Materiaux magMat = matDAO.getElementById(idMat);
					//Recuperation du stock par rapport a ce materiau
					int MatStock = queryStock.getInt(3);

					//Insertion dans leurs listes respectives
					ListStock.add(MatStock);
					listMat.add(magMat);

				}

				//Initialisation de l'objet Materiaux
				mag = new Magasin(id, nom, ListStock,listMat);
		} catch (SQLException e) {
			System.out.println("Unable to retrieve list" + "\n");
			e.printStackTrace();
		}
		
		
		return mag;
	}

}
