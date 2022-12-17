package Dao;

import java.util.ArrayList;
import java.util.List;

import model.Materiaux;

public class MateriauxDAO extends SuperDAO{
	
	public MateriauxDAO()
	{
		super("materiaux");
	}
	
	public List<Materiaux> getMateriaux()
	{
		List<Materiaux> results = new ArrayList<Materiaux>();
		results.add(new Materiaux(-1, "Exemple Materiaux", null));
		
		return results;
	}
	
	public Materiaux getElementById(int value)
	{
		if(value < 0)
		{
			return null;
		}
		
		return new Materiaux(-1, "MateriauxById", null);
	}

}
