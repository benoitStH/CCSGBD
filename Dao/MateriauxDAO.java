package Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Materiaux;
import utility.Utility;

public class MateriauxDAO extends SuperDAO{
	
	public MateriauxDAO()
	{
		super("materiaux");
	}
	
	/**
	 * GetElementById
	 * @param value
	 * @return Une liste materiaux correspondant 
	 */
	public Materiaux getElementById(int value)
	{
		Materiaux materiaux = null;
		ResultSet queryResultat = getElementById("idMat",value);
		
		try {
			while(queryResultat.next())
			{
				int id = queryResultat.getInt(1);
				String nom = queryResultat.getString(2);
				int idSub = queryResultat.getInt(3);
				if(idSub != 0)
				{
					ResultSet rs = getElementById("idMat", idSub);
					int idMATSub = rs.getInt(1);
					String nomSub = rs.getString(2);
					
					Materiaux sub = new Materiaux(idMATSub,nomSub,null);
					materiaux = new Materiaux(id, nom, sub);
					
				}else
				{
					materiaux = new Materiaux(id,nom,null);
				}
					
			}
		} catch (SQLException e) {
			System.out.println("Erreur: Lecture impossible" + "\n");
			e.printStackTrace();
		}
		return materiaux; 
			
	}

	public List<Materiaux> getMateriaux()
	{
		List<Materiaux> listMat = new ArrayList<>();
		try{
			Statement stmt = Utility.initConnexion().createStatement();
			String sql = "SELECT * FROM commande";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				listMat.add(getElementById(rs.getInt(1)));
			}
		}catch(SQLException sqlE)
		{
			System.out.println("Erreur");
			sqlE.printStackTrace();
		}

		return listMat;
	}

}
