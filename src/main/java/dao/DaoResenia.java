package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Resenia;


public class DaoResenia {

	private Connection con = null; 
	private static DaoResenia instance = null;
	
	public DaoResenia () throws SQLException {
		con = DBConexion.getConexion();
	}
	
	public static DaoResenia getInstance () throws SQLException {
		if(instance == null) {
			instance = new DaoResenia();
		}
		return instance;
	}
	
	
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
	
	public String listarJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listar());
		return json;
		
	}
	
	public void borrar (int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("DELETE FROM resenia WHERE id=?");
		ps.setInt(1, id);
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	
	
	
	
	
	
	
}
