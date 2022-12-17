package Dao;

import java.util.ArrayList;
import java.util.List;

import model.Composant;

public class ComposantDAO extends SuperDAO{
	
	public ComposantDAO()
	{
		super("composant");
	}
	
	public List<Composant> getComposants()
	{
		List<Composant> results = new ArrayList<Composant>();
		results.add(new Composant(-1, "Composant exemple", null));
		
		return results;
		
	}
	
	public Composant getElementById(int value)
	{
		if(value < 0)
		{
			return null;
		}
		
		return new Composant(value, "ComposantById", null);
	}

}
