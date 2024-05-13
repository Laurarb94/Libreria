package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Libro;

public class DaoLibro {

	private Connection con = null; 
	private static DaoLibro instance = null; 
	
	public DaoLibro () throws SQLException {
		con = DBConexion.getConexion();
	}
	
	public static DaoLibro getInstance() throws SQLException {
		if(instance == null) {
			instance = new DaoLibro();
		}
		return instance;
	}
	
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
	
	//Hago un método para listar mis libros en el catálogo
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
	
	
	//me hago un método para que me liste los datos anteriores (que estaban en formato arrayList) en formato Json
	public String listarJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listarLibros());
		return json;
	}
	
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
	
	public void borrar (int idLibro) throws SQLException {
		String sql = "DELETE FROM libros WHERE idLibro = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idLibro);
		int filas = ps.executeUpdate();
		ps.close();
	
	}
	
	
	
	
}
