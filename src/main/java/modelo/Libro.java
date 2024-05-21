package modelo;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import dao.DaoLibro;

public class Libro {

	int idLibro; 
	String isbn;
	String tituloLibro;
	String nombreAutorLibro; 
	String apellido1AutorLibro; 
	String apellido2AutorLibro; 
	String generoLibro;
	String psinopsis;
	String fotoPortada;
	
	public void Libro() {
		
	}

	public Libro(int idLibro, String isbn, String tituloLibro, String nombreAutorLibro, String apellido1AutorLibro,
			String apellido2AutorLibro, String generoLibro, String psinopsis, String fotoPortada) {
		super();
		this.idLibro = idLibro;
		this.isbn = isbn;
		this.tituloLibro = tituloLibro;
		this.nombreAutorLibro = nombreAutorLibro;
		this.apellido1AutorLibro = apellido1AutorLibro;
		this.apellido2AutorLibro = apellido2AutorLibro;
		this.generoLibro = generoLibro;
		this.psinopsis = psinopsis;
		this.fotoPortada = fotoPortada;
	}

	public Libro(String isbn, String tituloLibro, String nombreAutorLibro, String apellido1AutorLibro,
			String apellido2AutorLibro, String generoLibro, String psinopsis, String fotoPortada) {
		super();
		this.isbn = isbn;
		this.tituloLibro = tituloLibro;
		this.nombreAutorLibro = nombreAutorLibro;
		this.apellido1AutorLibro = apellido1AutorLibro;
		this.apellido2AutorLibro = apellido2AutorLibro;
		this.generoLibro = generoLibro;
		this.psinopsis = psinopsis;
		this.fotoPortada = fotoPortada;
	}

	public Libro(String isbn, String tituloLibro, String nombreAutorLibro, String apellido1AutorLibro,
			String apellido2AutorLibro, String generoLibro, String psinopsis) {
		super();
		this.isbn = isbn;
		this.tituloLibro = tituloLibro;
		this.nombreAutorLibro = nombreAutorLibro;
		this.apellido1AutorLibro = apellido1AutorLibro;
		this.apellido2AutorLibro = apellido2AutorLibro;
		this.generoLibro = generoLibro;
		this.psinopsis = psinopsis;
	}

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getNombreAutorLibro() {
		return nombreAutorLibro;
	}

	public void setNombreAutorLibro(String nombreAutorLibro) {
		this.nombreAutorLibro = nombreAutorLibro;
	}

	public String getApellido1AutorLibro() {
		return apellido1AutorLibro;
	}

	public void setApellido1AutorLibro(String apellido1AutorLibro) {
		this.apellido1AutorLibro = apellido1AutorLibro;
	}

	public String getApellido2AutorLibro() {
		return apellido2AutorLibro;
	}

	public void setApellido2AutorLibro(String apellido2AutorLibro) {
		this.apellido2AutorLibro = apellido2AutorLibro;
	}

	public String getGeneroLibro() {
		return generoLibro;
	}

	public void setGeneroLibro(String generoLibro) {
		this.generoLibro = generoLibro;
	}

	public String getPsinopsis() {
		return psinopsis;
	}

	public void setPsinopsis(String psinopsis) {
		this.psinopsis = psinopsis;
	}

	public String getFotoPortada() {
		return fotoPortada;
	}

	public void setFotoPortada(String fotoPortada) {
		this.fotoPortada = fotoPortada;
	}
	
	
	public void insertarLibro () throws SQLException {
		DaoLibro.getInstance().insertarLibro(this);
	}
	
	public void actualizar () throws SQLException {
		DaoLibro.getInstance().actualizar(this);
	}
	
	public void borrar (int idLibro) throws SQLException {
		DaoLibro.getInstance().borrar(idLibro);
	}
	
	public void obtenerPorId (int idLibro) throws SQLException {
		DaoLibro dao = new DaoLibro();
		Libro aux = dao.obtenerPorId(idLibro);
		
		this.setIdLibro(aux.getIdLibro());
		this.setIsbn(aux.getIsbn());
		this.setTituloLibro(aux.getTituloLibro());
		this.setNombreAutorLibro(aux.getNombreAutorLibro());
		this.setApellido1AutorLibro(aux.getApellido1AutorLibro());
		this.setApellido2AutorLibro(aux.getApellido2AutorLibro());
		this.setGeneroLibro(aux.getGeneroLibro());
		this.setPsinopsis(aux.getPsinopsis());
		this.setFotoPortada(aux.getFotoPortada());	
		
	}
	
	public String dameJson() {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;
	}
	

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", isbn=" + isbn + ", tituloLibro=" + tituloLibro + ", nombreAutorLibro="
				+ nombreAutorLibro + ", apellido1AutorLibro=" + apellido1AutorLibro + ", apellido2AutorLibro="
				+ apellido2AutorLibro + ", generoLibro=" + generoLibro + ", psinopsis=" + psinopsis + ", fotoPortada="
				+ fotoPortada + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
