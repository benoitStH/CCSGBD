package Controller;

import java.util.List;
import java.util.ArrayList;

import Dao.CategorieDAO;
import Model.Categorie;

public class ControllerCategorie {

	private CategorieDAO dao = new CategorieDAO();
	
	public List<Categorie> GetAllCategories()
	{
		return dao.getCategories();
	}
	
	public Categorie GetCategoryById(int value)
	{
		Categorie result = dao.getElementById(value);
		
		if(result == null)
		{
			System.out.println("Erreur : L'id "+value+" ne correspond à aucune catégorie");
			return new Categorie(-1, "####", null);
		}
		
		return result;
	}
	
	
}
