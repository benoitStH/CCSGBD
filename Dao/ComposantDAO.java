package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Composant;
import Model.Materiaux;

public class ComposantDAO extends SuperDAO{
	
	public ComposantDAO()
	{
		super("composant");
	}
	
	public Composant getElementById(int value)
	{
		Composant comp = null;
		List<Materiaux> listMat = new ArrayList();
		
		//Rcuperation du composant associé à l'ID
		ResultSet rs = getElementById("idComp",value);
		
		try {
			while(rs.next())
			{
				//Recuperation du nom et de l'id
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				
				//Requete SQL pour recuperer la liste des materiaux dont figure ce composant
				String sql = "SELECT * FROM composition WHERE idComp = " + rs + ";"; 
				ResultSet query = s.executeQuery(sql);
				
				while(query.next())
				{
					int idMat = query.getInt(1);
					//Recuperation des materiaux et ajout dans la liste
					MateriauxDAO matDao = new MateriauxDAO();
					listMat.add(matDao.getElementById(id));
					
				}
				
				comp = new Composant(id,nom,listMat);
				
			}
		} catch (SQLException e) {
			System.out.println("Unable to generate object" + "\n");
			e.printStackTrace();
		}
		
		return comp;
	}

}
