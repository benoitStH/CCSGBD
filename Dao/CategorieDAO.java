package Dao;

import Model.Categorie;
import Model.Materiaux;
import utility.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends SuperDAO {

	public CategorieDAO() {
		super("categorie");
		
	}
	
	public Categorie getElementById(int value)
	{
		int idCat = 0;
		String nomCat = null;
		Categorie categorie = null;
		List<Materiaux> listMat = new ArrayList<>();
		ResultSet rs =  getElementById("idCat",value);
		try{
			//Recuperation du nom et de l'id de la catégorie
			while(rs.next()) {
				idCat = rs.getInt(1);
				nomCat = rs.getString(2);
			}

			System.out.println(idCat + ": id de la categorie " + "\n");

		}catch(SQLException e)
		{
			System.out.println("Erreur: Lecture impossible" + "\n");
			e.printStackTrace();
		}

		try
		{
			//Seulement un ResultSet par Statement donc on crée un nouveau statement pour recuperer la nouvelle liste
			Statement stmt = Utility.initConnexion().createStatement();
			ResultSet query = stmt.executeQuery("SELECT * FROM materiaux WHERE idcat = " + idCat + ";");
			while (query.next())
			{
				int number = query.getInt(1);
				MateriauxDAO daoMat = new MateriauxDAO();
				Materiaux mat = daoMat.getElementById(number);
				System.out.println(mat + "\n");
				listMat.add(mat);
			}

			categorie = new Categorie(idCat,nomCat,listMat);
		}catch (SQLException e1)
		{
			System.out.println("Erreur: Lecture impossible" + "\n");
			e1.printStackTrace();
		}

		return categorie;
	}

	public List<Categorie> getCategories()
	{
		List<Categorie> listCat = new ArrayList<>();

		try{
			Statement stmt = Utility.initConnexion().createStatement();
			ResultSet rs;
			//Requete SQL pour récuperer la list des catégories
			String sql = "SELECT * FROM categorie";
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				listCat.add(getElementById(rs.getInt(1)));
			}

		}catch (SQLException sqle)
		{
			sqle.printStackTrace();
			System.out.println("Erreur lors de a recupération de la list des catégories");
		}



		return listCat;
	}

	
}
