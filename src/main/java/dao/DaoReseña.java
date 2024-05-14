package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Reseña;

public class DaoReseña {

	private Connection con = null; 
	private static DaoReseña instance = null;

	public DaoReseña () throws SQLException {
		con = DBConexion.getConexion();
	}

	public static DaoReseña getInstance () throws SQLException {
		if(instance == null) {
			instance = new DaoReseña();
		}
		return instance;
	}
	
	public void insertar(Reseña r) throws SQLException {
		String sql = "INSERT INTO reseña (titulo, fechaReseña, calificacionReseña, contenido, nombreUsuario) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, r.getTitulo());
		ps.setString(2, r.getFechaReseña());
		ps.setInt(3, r.getCalificacionReseña());
		ps.setString(4, r.getContenido());
		ps.setString(5, r.getNombreUsuario());
		
		int filas = ps.executeUpdate();
		ps.close();
		
	}
	
	public ArrayList<Reseña> listar() throws SQLException{
		String sql = "SELECT * FROM reseña";
		PreparedStatement ps = con.prepareStatement (sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Reseña> ls = null;
		
		while(rs.next()) {
			if(ls==null) {
				ls = new ArrayList <Reseña>();
			}
			ls.add(new Reseña (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
		}
		return ls;
	}
	
	public String listarJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listar());
		return json;
	}
	
	
	
	
	
	
	
	
}
