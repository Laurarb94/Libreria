package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;

/**
 * Clase para realizar operaciones CRUD relacionadas con la entidad usuario en la base de datos. 
 */
public class DaoUsuario {

	private Connection con = null; 
	private static DaoUsuario instance = null;

	/**
	 * Constructor privado. Evita que se pueda instanciar directamente la clase. 
	 * Utiliza DBConexion para poder conectarse a la bbdd
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public DaoUsuario () throws SQLException {
		con = DBConexion.getConexion();
	}

	/**
	 * Obtiene la instancia única de la clase DaoUsuario utilizando el Patrón Singleton.Este patrón permite que, al llamar a un método estático 
	 *  en la clase DaoUsuario me devuelva la propia clase, y al devolverme la propia clase ya se dispone de todos sus métodos. 
	 * @return instancia única de la clase DaoUsuario
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public static DaoUsuario getInstance () throws SQLException {
		if(instance == null) {
			instance = new DaoUsuario();
		}
		return instance;
	}
	
	/**
	 * Método para insertar un nuevo usuario en la bbdd. 
	 * @param usuario el usuario a insertar en la bbdd
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void insertarUsuario (Usuario usuario) throws SQLException {

		PreparedStatement ps = con.prepareStatement("INSERT into usuario (nombre, "
				+ "apellido1, apellido2, telefono, codPostal, mail, permiso, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

		ps.setString(1, usuario.getNombre());
		ps.setString(2, usuario.getApellido1());
		ps.setString(3, usuario.getApellido2());
		ps.setInt(4, usuario.getTelefono());
		ps.setInt(5, usuario.getCodPostal());
		ps.setString(6, usuario.getMail());
		ps.setInt(7, usuario.getPermiso());
		ps.setString(8, usuario.getPassword());		
		int filas = ps.executeUpdate();

		ps.close();

	}
	
	/**
	 * Método para obtener una lista con toda la información de los usuarios almacenada en la bbdd.
	 * @return lista de objetos usuario con la información de todos los usuarios almacenados en la bbdd.
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public ArrayList<Usuario> listarUsuarios() throws SQLException{
		String sql = "SELECT * FROM usuario";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> result = null;
		
		while(rs.next()) {
			if(result == null) {
				result = new ArrayList<Usuario>(); 
			}
			result.add(new Usuario (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
		}
		return result;
		
	}
	
	/**
	 * Método para que me liste los datos recogidos anteriormente en formato arrayList,en formato JSON. 
	 * @return lista de objetos usuario en formato JSON con la información de todos los usuarios almacenados en la bbdd.
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public String listarJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listarUsuarios());
		return json;
	}
	
	/**
	 * Método para borrar un usuario almacenado en la bbdd.
	 * @param id identificador único del usuario
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void borrarUsario (int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
		ps.setInt(1, id);

		int filas = ps.executeUpdate();

		ps.close();
	}
	
	/**
	 * Método para obtener los datos del usuario a través de su id.
	 * @param id identificador único del usuario
	 * @return objeto usuario con los datos del usuario corresopndientes al id proporcionado. 
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public Usuario obtenerPorID(int id) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Usuario u = new Usuario (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)); 

		return u;
	}
	
	/**
	 * Método para actualizar un usuario. 
	 * @param u datos del usuario que se quiere actualizar 
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public void actualizar (Usuario u) throws SQLException {
		String sql = "UPDATE usuario SET nombre=?, apellido1=?, apellido2=?, telefono=?, codPostal=?, mail=?, permiso=? "
				+ "WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellido1());
		ps.setString(3, u.getApellido2());
		ps.setInt(4, u.getTelefono());
		ps.setInt(5, u.getCodPostal());
		ps.setString(6, u.getMail());
		ps.setInt(7, u.getPermiso());
		ps.setInt(8, u.getId());
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	/**
	 * Método para verificar las credenciales del mail y contraseña del usuario en el inicio de sesión. 
	 * @param u usuario que quiere iniciar sesión. 
	 * @param password contraseña del usuario para poder iniciar sesión. 
	 * @return objeto usuario si las credenciales son válidas en el inico de sesión. 
	 * @throws SQLException si ocurre un error al obtener la conexión a la bbdd
	 */
	public Usuario logueando(Usuario u, String password) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE mail=? AND password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getMail());
		ps.setString(2, password);
	
		ResultSet rs = ps.executeQuery();
		Usuario aux = null;
		//meto el if porque si no, al meter un usuario que no está registrado me da error porque me dice que el ResutSet está vacío
		if(rs.next()) {
			aux = new Usuario  (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)); 
		}
		
		ps.close();
		
		return aux;
		
		
		}
		
	}
	
	
		
		
	
	
	


	


	
	
	
	

