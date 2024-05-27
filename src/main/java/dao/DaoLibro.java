package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import modelo.Libro;
/**
 * Clase para realizar operaciones CRUD relacionadas con la entidad libro en la base de datos. 
 */
public class DaoLibro {

	private Connection con = null; 
	private static DaoLibro instance = null; 
	

	/**
	 * Constructor de la clase DaoLibro. Utiliza DBConexion para poder conectarse a la bbdd
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public DaoLibro () throws SQLException {
		con = DBConexion.getConexion();
	}
	
	/**
	 * Obtiene la instancia única de la clase DaoLibro utilizando el Patrón Singleton.Este patrón permite que, al llamar a un método estático 
	 * en la clase DaoLibro me devuelva la propia clase, y al devolverme la propia clase ya se dispone de todos sus métodos. 
	 * @return instancia única de la clase DaoLibro
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public static DaoLibro getInstance() throws SQLException {
		if(instance == null) {
			instance = new DaoLibro();
		}
		return instance;
	}
	
	/**
	 * Método para insertar un nuevo libro en la bbdd. 
	 * @param l el libro a insertar en la bbdd
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void insertarLibro(Libro l) throws SQLException {
		PreparedStatement ps = con.prepareStatement 
				("INSERT into libros(isbn, tituloLibro, nombreAutorLibro, apellido1AutorLibro,"
						+ "apellido2AutorLibro, generoLibro, psinopsis ,fotoPortada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		ps.setString(1, l.getIsbn());
		ps.setString(2, l.getTituloLibro());
		ps.setString(3, l.getNombreAutorLibro());
		ps.setString(4, l.getApellido1AutorLibro());
		ps.setString(5, l.getApellido2AutorLibro());
		ps.setString(6, l.getGeneroLibro());
		ps.setString(7, l.getPsinopsis());
		ps.setString(8, l.getFotoPortada());
		
		
		int filas = ps.executeUpdate();
		ps.close();	
	}
	
	/**
	 * Método para listar toda la información del libro almacenada en la bbdd.
	 * @return lista de objetos libro con la información de todos los libros almacenados en la bbdd.
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public ArrayList<Libro>listarLibros () throws SQLException{
		PreparedStatement ps = con.prepareStatement("SELECT * FROM libros");
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Libro> result = null;
		
		while (rs.next()) {
			
			if(result == null) {
				result = new ArrayList<Libro>();				
			}
			result.add(new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));		
		}	
		return result;
	}
	
	/**
	 * Método para que me liste los datos recogidos anteriormente en formato arrayList,en formato JSON. 
	 * @return lista de objetos libro en formato JSON con la información de todos los libros almacenados en la bbdd.
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
		public String listarJson() throws SQLException {
			String json = "";
			Gson gson = new Gson();
			json = gson.toJson(this.listarLibros());
			return json;
		}
		
		
		/**
		 * Metodo para listar libros de un determinado género
		 * @param tipo género de los libros que se desea listar
		 * @return la lista de objetos libro del género especificado
		 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
		 */
		public ArrayList<Libro>listarLibros (String tipo) throws SQLException{
			
			ArrayList<Libro> result = new ArrayList<Libro>();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM libros WHERE generoLibro=?");
			ps.setString(1, tipo);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				
				if(result == null) {
					result = new ArrayList<Libro>();				
				}
				result.add(new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));		
			}	
			return result;
		}
		
	/**
	 * Método para obtener los datos del libro a través de su id
	 * @param idLibro identificador único del libro
	 * @return objeto libro con los datos del libro corresopndientes al id proporcionado. 
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public Libro obtenerPorId(int idLibro) throws SQLException {
		String sql = "SELECT * FROM libros WHERE idLibro =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idLibro);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Libro l = new Libro (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
				rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		
		return l; 	
	}
	
	/**
	 * Método para obtener una lista de libros de un determinado género en formato JSON
	 * @param tipo el género de los libros que se quiere listar en formato JSON
	 * @return una cadena de texto que representa una lista de objetos libro en formato JSON en el género especificado
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public String listarJson(String tipo) throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listarLibros(tipo));
		return json;
	}
	
	/**
	 * Método para actualizar un libro 
	 * @param l datos del libro que se quiere actualizar 
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void actualizar (Libro l) throws SQLException {
		String sql = "UPDATE libros SET isbn=?, tituloLibro=?, nombreAutorLibro=?, apellido1AutorLibro=?, "
				+ "apellido2AutorLibro=?, generoLibro=?, psinopsis=?, fotoPortada=? WHERE idLibro =?";
			
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, l.getIsbn());
	ps.setString(2, l.getTituloLibro());
	ps.setString(3, l.getNombreAutorLibro());
	ps.setString(4, l.getApellido1AutorLibro());
	ps.setString(5, l.getApellido2AutorLibro());
	ps.setString(6, l.getGeneroLibro());
	ps.setString(7, l.getPsinopsis());
	ps.setString(8, l.getFotoPortada());
	ps.setInt(9, l.getIdLibro());
	
	int filas = ps.executeUpdate();
	ps.close();		
				
	}
	
	/**
	 * Método para borrar un libro de la bbdd
	 * @param idLibro identificador único del libro que se quiere borrar
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void borrar (int idLibro) throws SQLException {
		String sql = "DELETE FROM libros WHERE idLibro = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idLibro);
		int filas = ps.executeUpdate();
		ps.close();
	
	}
	
	
	
	
	
	
	
	
	
}
