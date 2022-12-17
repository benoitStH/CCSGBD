package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Categorie;

public class CategorieDAO extends SuperDAO {

	public CategorieDAO() {
		super("categorie");
		
	}
	
	public List<Categorie> getCategories()
	{
		List<Categorie> results = new ArrayList<Categorie>();
		results.add(new Categorie(-1, "Exemple"));
		
		return results;
	}
	
	public Categorie getElementById(int value)
	{
		
		return new Categorie(-1, "Exemple DAOCateg ElementById");
		
	}

	
}
