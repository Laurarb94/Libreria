package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Resenia;

/**
 * Clase para realizar operaciones CRUD relacionadas con la entidad resenia en la base de datos. 
 */
public class DaoResenia {

	private Connection con = null; 
	private static DaoResenia instance = null;
	
	/**
	 * Constructor de la clase DaoResenia. Utiliza DBConexion para poder conectarse a la bbdd
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public DaoResenia () throws SQLException {
		con = DBConexion.getConexion();
	}
	
	/**
	 * Obtiene la instancia única de la clase DaoResenia utilizando el Patrón Singleton.Este patrón permite que, al llamar a un método estático 
	 * en la clase DaoResenia me devuelva la propia clase, y al devolverme la propia clase ya se dispone de todos sus métodos. 
	 * @return instancia única de la clase DaoResenia
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public static DaoResenia getInstance () throws SQLException {
		if(instance == null) {
			instance = new DaoResenia();
		}
		return instance;
	}
	
	/**
	 * Método para insertar una nueva resenia en la bbdd
	 * @param r la resenia a insertar en la bbdd
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void insertar (Resenia r) throws SQLException {
		String sql = "INSERT INTO resenia (titulo, fecha, calificacion, contenido, nombreEscribeResenia) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement (sql);
		
		ps.setString(1, r.getTitulo());
		ps.setString(2, r.getFecha());
		ps.setInt(3, r.getCalificacion());
		ps.setString(4, r.getContenido());
		ps.setString(5, r.getNombreEscribeResenia());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * Método para listar toda la información de resenia almacenada en la bbdd
	 * @return lista de objetos resenia con la información de todas las resenias alamcenadas. 
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public ArrayList<Resenia> listar() throws SQLException{
		String sql = "SELECT * FROM resenia";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Resenia> ls  = null; 
		
		while (rs.next()) {
			if (ls == null) {
				ls = new ArrayList<Resenia> ();
			}
			ls.add(new Resenia (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
		}
		return ls;	
	}
	
	/**
	 * Método para que me liste los datos recogidos anteriormente en formato arrayList,en formato JSON. 
	 * @return lista de objeto resenia en formato JSON con la información de todas las resenias almacenados en la bbdd.
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public String listarJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listar());
		return json;
	}
	
	/**
	 * Método para borrar resenia almacenada en la bbdd
	 * @param idResenia identificador único de la resenia
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void borrar (int idResenia) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM resenia WHERE id=?");
		ps.setInt(1, idResenia);
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	
	
	
	
	
	
	
}
