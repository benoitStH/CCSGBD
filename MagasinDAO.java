package Dao;

import java.util.ArrayList;
import java.util.List;

import model.Magasin;

public class MagasinDAO extends SuperDAO{
	
	public MagasinDAO()
	{
		super("magasin");
	}
	
	public List<Magasin> getMagasins()
	{
		List<Magasin> results = new ArrayList<Magasin>();
		results.add(new Magasin(-1, "Magasin Exemple", null));
		
		return results;
	}
	
	public Magasin getElementById(int value)
	{
		if(value < 0)
		{
			return null;
		}
		
		return new Magasin(value, "MagasinById", null);
	}

}
