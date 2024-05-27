package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase DBConexion, proporciona una sola conexion a la base de datos
 */
public class DBConexion {

	/**
	 * Instancia unica a la conexion de la bbdd
	 */
	public static Connection instance = null; 
	
	/**
	 * URL para la conexion JDBC a la bbdd 
	 */
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/libreria";
	
	/**
	 * Constructor privado para evitar instancias de esta clase. 
	 */
	private DBConexion() {
		
	}

	/**
	 * Metodo que implementa el patron Singleton. Devuelve una instancia unica de la conexion a la bbdd. 
	 * Si la conexion no existe se crea una nueva
	 * @return la instancia unica de la conexion a la bbdd. 
	 * @throws SQLException si ocurre un error al intentar conectar a la bbdd
	 */
	public static Connection getConexion () throws SQLException {
		
		if(instance == null ) {
			instance = DriverManager.getConnection(JDBC_URL, "root", "1234");
		}
		
		return instance; 
	}
	
	
	
	
	
}
