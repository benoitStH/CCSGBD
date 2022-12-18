package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Commande;
import Model.Composant;
import Model.Materiaux;
import utility.Utility;

public class ComposantDAO extends SuperDAO{
	
	public ComposantDAO()
	{
		super("composant");
	}
	
	public Composant getElementById(int value)
	{
		Composant comp = null;
		List<Materiaux> listMat = new ArrayList();
		int id = 0 ;
		String nom = null;
		
		//Rcuperation du composant associé à l'ID
		ResultSet rs = getElementById("idComp",value);
		
		try {
			while(rs.next())
			{
				//Recuperation du nom et de l'id
				id = rs.getInt(1);
				nom = rs.getString(2);
				
			}
		} catch (SQLException e) {
			System.out.println("Unable to generate object" + "\n");
			e.printStackTrace();
		}

		try {
			//Requete SQL pour recuperer la liste des materiaux dont figure ce composant
			Statement stmt = Utility.initConnexion().createStatement();
			String sql = "SELECT * FROM composition WHERE idComp = " + id + ";";
			ResultSet query = stmt.executeQuery(sql);

			while(query.next())
			{
				int idMat = query.getInt(1);
				//Recuperation des materiaux et ajout dans la liste
				MateriauxDAO matDao = new MateriauxDAO();
				listMat.add(matDao.getElementById(id));

			}

			comp = new Composant(id,nom,listMat);
		} catch (SQLException e) {
		System.out.println("Unable to generate object" + "\n");
		e.printStackTrace();
		}
		
		return comp;
	}


	public List<Composant> getComposants()
	{
		List<Composant> listCom = new ArrayList<>();
		try{
			Statement stmt = Utility.initConnexion().createStatement();
			String sql = "SELECT * FROM composant";
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
