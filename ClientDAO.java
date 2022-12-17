package Dao;

import model.Client;

public class ClientDAO extends SuperDAO {

	public ClientDAO() {
		super("client");
		
	}
	
	public Client getElementById(int value)
	{
		if(value < 0)
		{
			return null;
		}
		
		return new Client(value, "nom", "prenom", null);
	}

}
