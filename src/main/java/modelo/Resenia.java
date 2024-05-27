package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoResenia;


/**
 * Clase que representa una reseña del sistema. 
 * Esta clase almacena informacion acerca de su id, titulo del libro que se reseña, fecha, calificacion, contenido y usuario que la escribe.
 * Se va a utlizar para crear, modificar, borrar y/o recuperar informacion sobre usuarios del sistema. 
 */
public class Resenia {

	/**
	 * Representa el id del usuario
	 */
	private int idResenia;
	
	/**
	 * Representa el titulo del libro que se va a hacer la reseña
	 */
	private String titulo;
	
	/**
	 * Representa la fecha en la que se hace la reseña
	 */
	private String fecha;
	
	/**
	 * Representa la calificacion de la reseña
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
	 * Constructor para generar un objeto vacio de tipo reseña
	 */
	public Resenia() {
		
	}

	/**
	 * Constructor para <strong>creacion del objeto. Este constructor se usa cuando los datos van a la bbdd</strong>
	 * @param id identificador unico de la reseña
	 * @param titulo el titulo del libro que se reseña
	 * @param fecha la fecha en que se realiza la reseña
	 * @param calificacion la calificacion de la reseña
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
	 *  @param titulo el titulo del libro que se reseña
	 * @param fecha la fecha en que se realiza la reseña
	 * @param calificacion la calificacion de la reseña
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
	 * Metodo de inclusion del id en el objeto resenia
	 * @return retorna el id en tipo entero
	 */
	public int getIdResenia() {
		return idResenia;
	}

	/**
	 * Metodo para establcer el identificador unico del usuario
	 * @param idResenia forma en que se establece el identificador de la resenia
	 */
	public void setIdResenia(int idResenia) {
		this.idResenia = idResenia;
	}

	/**
	 * Metodo para obtener el titulo del libro
	 * @return el titulo del libro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo para establecer el titulo del libro que se resenia
	 * @param titulo el nuevo titulo del libro que se resenia
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo para obtener la fecha de la resenia
	 * @return la fecha de la resenia
	 */
	public String getFecha() {
		return fecha;
	}
 
	/**
	 * Metodo para establecer la fecha de la resenia
	 * @param fecha la nueva fecha de la resenia
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo para obtener la calificacion de la resenia
	 * @return la calificacion de la resenia
	 */

	public int getCalificacion() {
		return calificacion;
	}
	
	/**
	 * Metodo para establecer la calificacion de la resenia
	 * @param calificacion la nueva calificacion de la resenia
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * Metodo para obtener el contenido de la resenia
	 * @return el contenido de la resenia
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Metodo para establecer el contenido de la resenia
	 * @param contenido el nuevo contenido de la resenia
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Metodo para obtener el nombre del usuario que escribe la resenia
	 * @return el nombre del usuario que escribe la resenia
	 */
	public String getNombreEscribeResenia() {
		return nombreEscribeResenia;
	}

	/**
	 * Metodo para establecer el nombre del usuario que escribe la resenia
	 * @param nombreEscribeResenia el nuevo nombre del usuario que escribe la resenia
	 */
	public void setNombreEscribeResenia(String nombreEscribeResenia) {
		this.nombreEscribeResenia = nombreEscribeResenia;
	}

	/**
	 * Metodo toString. Devuelve una representacion de cadena del objeto resenia. Esta representacion 
	 * incluye los valores de todos los atributos del obteto. 
	 */
	@Override
	public String toString() {
		return "Resenia [idResenia=" + idResenia + ", titulo=" + titulo + ", fecha=" + fecha + ", calificacion=" + calificacion
				+ ", contenido=" + contenido + ", nombreEscribeResenia=" + nombreEscribeResenia + "]";
	}
	
	/**
	 * Metodo que inserta el objeto resenia en la base de datos. Utiliza el patron Singleton para obtener la instancia Dao. 
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos. 
	 */
	public void insertar() throws SQLException {
		DaoResenia.getInstance().insertar(this);
	}
	
	/**
	 * Metodo para borrar el objeto resenia en la base de datos. Utiliza el patron Singleton para obtener la instancia Dao. 
	 * @param id identificador unico de la resenia
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
	public void borrar() throws SQLException {
		DaoResenia.getInstance().borrar(idResenia);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
