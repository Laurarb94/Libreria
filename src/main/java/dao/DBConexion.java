package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase DBConexion, proporciona una conexión única a la base de datos
 */
public class DBConexion {

	/**
	 * Instancia única a la conexión de la bbdd
	 */
	public static Connection instance = null; 
	
	/**
	 * URL para la conexión JDBC a la bbdd 
	 */
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/libreria";
	
	/**
	 * Constructor privado para evitar instancias de esta clase. 
	 */
	private DBConexion() {
		
	}

	/**
	 * Método que implementa el patrón Singleton. Devuelve una instancia única de la conexión a la bbdd. 
	 * Si la conexión no existe se crea una nueva
	 * @return la instancia única de la conexión a la bbdd. 
	 * @throws SQLException si ocurre un error al intentar conectar a la bbdd
	 */
	public static Connection getConexion () throws SQLException {
		
		if(instance == null ) {
			instance = DriverManager.getConnection(JDBC_URL, "root", "1234");
		}
		
		return instance; 
	}
	
	
	
	
	
}
