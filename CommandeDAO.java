package Dao;

import java.sql.ResultSet;

public class CommandeDAO extends SuperDAO{
	
	public CommandeDAO()
	{
		super("commande");
	}
	
	protected ResultSet getElementById(int value)
	{
		return getElementById("idCom",value);
	}

}
