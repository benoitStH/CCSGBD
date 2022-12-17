package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Utility {
	
	public static Connection initConnexion()
	{
		
		
		Properties userInfo = new Properties();
		userInfo.setProperty("user", "root");
		userInfo.setProperty("password", "password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Pilote non trouvé!");
			System.exit(1);
		}
		try {
			Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ccsgbd",
				userInfo.getProperty("user"),userInfo.getProperty("password")	);
			return c;	
			
		} catch (SQLException ex2) {
			System.out.println("Erreur JDBC: "+ex2);
			System.exit(1);

		}
		return null;
		
		
	}

	public static void createTable(Statement stmt,String database ,String table, String query) throws SQLException
	{
			try {
				
				stmt.executeUpdate("CREATE IF NOT EXISTS "+ database +" TPSGBD");
			}catch(SQLException ex3)
			{
				System.out.println("Database already connected");
			}
			
			
			String data = "CREATE TABLE IF NOT EXISTS "+ table + query ;
				
				stmt.executeUpdate(data);
			

	}
	
	public static void closeConnection(Connection c)throws SQLException
	{
		
			c.close();
	
	}
	
	public static void addData(Statement stmt, String table, String data) throws SQLException
	{
		String sql = "INSERT INTO "+ table + " VALUES" + data;
		stmt.executeUpdate(sql);
	}
	
	public static void deleteData(Statement stmt, String table, String data) throws SQLException
	{
		stmt.executeUpdate("DELETE FROM" + table +" WHERE " + data);
	}
	
}
