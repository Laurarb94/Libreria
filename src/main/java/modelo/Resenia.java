package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoResenia;


/**
 * Clase que representa una reseña del sistema. 
 * Esta clase almacena información acerca de su id, título del libro que se reseña, fecha, calificación, contenido y usuario que la escribe.
 * Se va a utlizar para crear, modificar, borrar y/o recuperar información sobre usuarios del sistema. 
 */
public class Resenia {

	/**
	 * Representa el id del usuario
	 */
	private int idResenia;
	
	/**
	 * Representa el título del libro que se va a hacer la reseña
	 */
	private String titulo;
	
	/**
	 * Representa la fecha en la que se hace la reseña
	 */
	private String fecha;
	
	/**
	 * Representa la calificación de la reseña
	 */
	private int calificacion;
	
	/**
	 * Representa el contenido de la reseña
	 */
	private String contenido;
	
	/**
	 * Representa el nombre del usuario que escribe la reseña
	 */
	private String nombreEscribeResenia;
	
	/**
	 * Constructor para generar un objeto vacío de tipo reseña
	 */
	public Resenia() {
		
	}

	/**
	 * Constructor para <strong>creación del objeto. Este constructor se usa cuando los datos van a la bbdd</strong>
	 * @param id identificador único de la reseña
	 * @param titulo el título del libro que se reseña
	 * @param fecha la fecha en que se realiza la reseña
	 * @param calificacion la calificación de la reseña
	 * @param contenido el contenido de la reseña
	 * @param nombreEscribeResenia el nombre del usuario que escribe la reseña
	 */
	
	public Resenia(int idResenia, String titulo, String fecha, int calificacion, String contenido,
			String nombreEscribeResenia) {
		super();
		this.idResenia = idResenia;
		this.titulo = titulo;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.contenido = contenido;
		this.nombreEscribeResenia = nombreEscribeResenia;
	}

	/**
	 * Constructor para <strong>creación del objeto. Este constructor se usa cuando los datos vienen de un formulario</strong>
	 *  @param titulo el título del libro que se reseña
	 * @param fecha la fecha en que se realiza la reseña
	 * @param calificacion la calificación de la reseña
	 * @param contenido el contenido de la reseña
	 * @param nombreEscribeResenia el nombre del usuario que escribe la reseña
	 */
	public Resenia(String titulo, String fecha, int calificacion, String contenido, String nombreEscribeResenia) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.calificacion = calificacion;
		this.contenido = contenido;
		this.nombreEscribeResenia = nombreEscribeResenia;
	}

	/**
	 * Método de inclusión del id en el objeto resenia
	 * @return retorna el id en tipo entero
	 */
	public int getIdResenia() {
		return idResenia;
	}

	/**
	 * Método para establcer el identificador único del ysyario
	 * @param idResenia forma en que se establece el identificador de la resenia
	 */
	public void setIdResenia(int idResenia) {
		this.idResenia = idResenia;
	}

	/**
	 * Método para obtener el título del libro
	 * @return el título del libro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Método para establecer el título del libro que se resenia
	 * @param titulo el nuevo título del libro que se resenia
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Método para obtener la fecha de la resenia
	 * @return la fecha de la resenia
	 */
	public String getFecha() {
		return fecha;
	}
 
	/**
	 * Método para establecer la fecha de la resenia
	 * @param fecha la nueva fecha de la resenia
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Método para obtener la calificación de la resenia
	 * @return la calificación de la resenia
	 */

	public int getCalificacion() {
		return calificacion;
	}
	
	/**
	 * Método para establecer la calificación de la resenia
	 * @param calificacion la nueva calificación de la resenia
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * Método para obtener el contenid de la resenia
	 * @return el contenido de la resenia
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Método para establecer el contenido de la resenia
	 * @param contenido el nuevo contenido de la resenia
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Método para obtener el nombre del usuario que escribe la resenia
	 * @return el nombre del usuario que escribe la resenia
	 */
	public String getNombreEscribeResenia() {
		return nombreEscribeResenia;
	}

	/**
	 * Método para establecer el nombre del usuario que escribe la resenia
	 * @param nombreEscribeResenia el nuevo nombre del usuario que escribe la resenia
	 */
	public void setNombreEscribeResenia(String nombreEscribeResenia) {
		this.nombreEscribeResenia = nombreEscribeResenia;
	}

	/**
	 * Método toString. Devuelve una representación de cadena del objeto resenia. Esta representación 
	 * incluye los valores de todos los atributos del obteto. 
	 */
	@Override
	public String toString() {
		return "Resenia [idResenia=" + idResenia + ", titulo=" + titulo + ", fecha=" + fecha + ", calificacion=" + calificacion
				+ ", contenido=" + contenido + ", nombreEscribeResenia=" + nombreEscribeResenia + "]";
	}
	
	/**
	 * Método que inserta el objeto resenia en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos. 
	 */
	public void insertar() throws SQLException {
		DaoResenia.getInstance().insertar(this);
	}
	
	/**
	 * Método para borrar el objeto resenia en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @param id identificador único de la resenia
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
	public void borrar() throws SQLException {
		DaoResenia.getInstance().borrar(idResenia);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
