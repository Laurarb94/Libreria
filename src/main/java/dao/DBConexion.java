package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {

	public static Connection instance = null; 
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/libreria";
	
	
	private DBConexion() {
		
	}

	public static Connection getConexion () throws SQLException {
		
		if(instance == null ) {
			instance = DriverManager.getConnection(JDBC_URL, "root", "1234");
		}
		
		return instance; 
	}
	
	
	
	
	
}
