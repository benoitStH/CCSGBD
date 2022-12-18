package Controller;

import java.util.List;

import Dao.ComposantDAO;
import Model.Composant;

public class ControllerComposant {

	private ComposantDAO dao = new ComposantDAO();
	
	public List<Composant> GetAllComposants()
	{
		return dao.getComposants();
	}
	
	public Composant GetComposantById(int value)
	{
		Composant result = dao.getElementById(value);
		
		if(result == null)
		{
			System.out.println("Erreur : L'id "+value+" ne correspond à aucun composant");
			return new Composant(-1, "####", null);
		}
		
		return result;
	}
}
