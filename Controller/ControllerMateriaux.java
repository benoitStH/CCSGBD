package Controller;

import java.util.List;

import Dao.MateriauxDAO;
import Model.Composant;
import Model.Materiaux;

public class ControllerMateriaux {

	private MateriauxDAO dao = new MateriauxDAO();
	
	public List<Materiaux> getAllMateriaux()
	{
		return dao.getMateriaux();
	}
	
	public Materiaux getMateriauxById(int value)
	{
		Materiaux result = dao.getElementById(value);
		
		if(result == null)
		{
			System.out.println("Erreur : L'id "+value+" ne correspond à aucun materiel");
			return new Materiaux(-1, "####", null);
		}
		
		return result;
	}
	
}
