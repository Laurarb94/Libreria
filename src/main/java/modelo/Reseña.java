package modelo;

import java.sql.SQLException;

import dao.DaoReseña;

public class Reseña {

	private int idReseña;
	private String titulo;
	private String fechaReseña;
	private int calificacionReseña;
	private String contenido;
	private String nombreUsuario;
	
	public Reseña() {
		
	}

	public Reseña(int idReseña, String titulo, String fechaReseña, int calificacionReseña, String contenido,
			String nombreUsuario) {
		super();
		this.idReseña = idReseña;
		this.titulo = titulo;
		this.fechaReseña = fechaReseña;
		this.calificacionReseña = calificacionReseña;
		this.contenido = contenido;
		this.nombreUsuario = nombreUsuario;
	}

	public Reseña(String titulo, String fechaReseña, int calificacionReseña, String contenido, String nombreUsuario) {
		super();
		this.titulo = titulo;
		this.fechaReseña = fechaReseña;
		this.calificacionReseña = calificacionReseña;
		this.contenido = contenido;
		this.nombreUsuario = nombreUsuario;
	}

	public int getIdReseña() {
		return idReseña;
	}

	public void setIdReseña(int idReseña) {
		this.idReseña = idReseña;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaReseña() {
		return fechaReseña;
	}

	public void setFechaReseña(String fechaReseña) {
		this.fechaReseña = fechaReseña;
	}

	public int getCalificacionReseña() {
		return calificacionReseña;
	}

	public void setCalificacionReseña(int calificacionReseña) {
		this.calificacionReseña = calificacionReseña;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void insertar () throws SQLException {
		DaoReseña.getInstance().insertar(this);
	}
	
	

	
	
	@Override
	public String toString() {
		return "Reseña [idReseña=" + idReseña + ", titulo=" + titulo + ", fechaReseña=" + fechaReseña
				+ ", calificacionReseña=" + calificacionReseña + ", contenido=" + contenido + ", nombreUsuario="
				+ nombreUsuario + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
