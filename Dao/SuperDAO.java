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
	
	public ResultSet getElements()
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
	
	public ResultSet getElementById(String idname, int value)
	{
		String query = "SELECT * FROM " + tableName + " WHERE "+ idname + "= " + value +";" ;
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
	
	protected static void addData(String table, String data) 
	{
		String sql = "INSERT INTO "+ table + " VALUES" + data;
		try {
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Unable to insert data" + "\n");
			e.printStackTrace();
		}
	}


	public static void setS(Statement s) {
		SuperDAO.s = s;
	}
}
