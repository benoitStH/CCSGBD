package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SuperDAO {
	
	public static Statement s;
	private String tableName;
	
	
	
	
	public SuperDAO(String tableName) {
		this.tableName = tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	protected ResultSet getElements()
	{
		String query = "SELECT * FROM " + tableName + ";";
		ResultSet results;  
		try {
			
			results = s.executeQuery(query);
			
			
		}catch(SQLException e)
		{
			System.out.println("Element introuvable dans la table :" + tableName);
			e.printStackTrace();
			return null;
		}
		
		return results;
		
	}
	
	protected ResultSet getElementById(String idname, int value)
	{
		String query = "SELECT * FROM " + tableName + "WHERE "+ idname + "=" + value +";" ;
		ResultSet results;  
		try {
			
			results = s.executeQuery(query);
			
			
		}catch(SQLException e)
		{
			System.out.println("Element introuvable dans la table :" + tableName);
			e.printStackTrace();
			return null;
		}
		
		return results;
	}

}
