package Controller;

import java.util.List;

import Dao.MagasinDAO;
import model.Magasin;
import model.Materiaux;

public class ControllerMagasin {
	
	private MagasinDAO dao = new MagasinDAO();
	
	public List<Magasin> GetAllMagasin()
	{
		return dao.getMagasins();
	}
	
	public Magasin getMagasinById(int value)
	{
		Magasin result = dao.getElementById(value);
		
		if(result == null)
		{
			System.out.println("Erreur : L'id "+value+" ne correspond à aucun magasin");
			return new Magasin(-1, "####", null, null);
		}
		
		return result;
	}
	
	

}
