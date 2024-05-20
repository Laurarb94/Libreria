package modelo;

public class Resenia {

	private int id;
	private String titulo;
	private String fecha;
	private int calificacion;
	private String contenido;
	private String nombreEscribeResenia;
	
	
	public Resenia() {
		
	}


	public Resenia(int id, String titulo, String fecha, int calificacion, String contenido,
			String nombreEscribeResenia) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.contenido = contenido;
		this.nombreEscribeResenia = nombreEscribeResenia;
	}


	public Resenia(String titulo, String fecha, int calificacion, String contenido, String nombreEscribeResenia) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.contenido = contenido;
		this.nombreEscribeResenia = nombreEscribeResenia;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public String getNombreEscribeResenia() {
		return nombreEscribeResenia;
	}


	public void setNombreEscribeResenia(String nombreEscribeResenia) {
		this.nombreEscribeResenia = nombreEscribeResenia;
	}


	@Override
	public String toString() {
		return "Resenia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", calificacion=" + calificacion
				+ ", contenido=" + contenido + ", nombreEscribeResenia=" + nombreEscribeResenia + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
