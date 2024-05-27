package modelo;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import dao.DaoLibro;

/**
 * Clase que representa el objeto Libro en el sistema. Esta clase va a almacenar información relativa al id del libro, su isbn, 
 * título, datos del autor,el género, la psinopsis y la foto de portada. 
 */
public class Libro {

	/**
	 * Representa el id del Libro
	 */
	int idLibro; 
	/**
	 * Representa el isbn del Libro
	 */
	String isbn;
	/**
	 * Representa el título del Libro
	 */
	String tituloLibro;
	/**
	 * Representa el nombre del autor del Libro
	 */
	String nombreAutorLibro; 
	/**
	 * Representa el primer apellido del autor del Libro
	 */
	String apellido1AutorLibro; 
	/**
	 * Representa el segundo apellido del autor del Libro
	 */
	String apellido2AutorLibro; 
	/**
	 * Representa el género del Libro
	 */
	String generoLibro;
	/**
	 * Representa la psinopsis del Libro
	 */
	String psinopsis;
	/**
	 * Representa la foto de portada del Libro
	 */
	String fotoPortada;
	
	/**
	 * Constructor que genera un objeto vacío de tipo libro
	 */
	public Libro() {
		
	}

	/**
	 * Constructor para <strong>creación del objeto. Este constructor se usa cuando los datos van a la bbdd</strong>
	 * @param idLibro identificador único del objeto libro
	 * @param isbn el isbn del libro
	 * @param tituloLibro el título del libro
	 * @param nombreAutorLibro el nombre del autor que ha escrito el libro
	 * @param apellido1AutorLibro el primer apellido del autor que ha escrito el libro
	 * @param apellido2AutorLibro el segundo apellido del autor que ha escrito el libro
	 * @param generoLibro el género del libro 
	 * @param psinopsis la psinopsis del libro
	 * @param fotoPortada la foto de portada del libro
	 */
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

	/**
	 * Constructor para <strong>creación del objeto libro. Este constructor se usa cuando los datos vienen de un formulario</strong>
	 * @param isbn el isbn del libro
	 * @param tituloLibro el título del libro
	 * @param nombreAutorLibro el nombre del autor que ha escrito el libro
	 * @param apellido1AutorLibro el primer apellido del autor que ha escrito el libro
	 * @param apellido2AutorLibro el segundo apellido del autor que ha escrito el libro
	 * @param generoLibro el género del libro 
	 * @param psinopsis la psinopsis del libro
	 * @param fotoPortada la foto de portada del libro
	 */
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

	
	/**
	 * Constructor para <strong>creación del objeto libro</strong>. Constructor sin id y sin foto de portada.
	 *  @param isbn el isbn del libro
	 * @param tituloLibro el título del libro
	 * @param nombreAutorLibro el nombre del autor que ha escrito el libro
	 * @param apellido1AutorLibro el primer apellido del autor que ha escrito el libro
	 * @param apellido2AutorLibro el segundo apellido del autor que ha escrito el libro
	 * @param generoLibro el género del libro 
	 * @param psinopsis la psinopsis del libro
	 */
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
	
	/**
	 * Método de inclusión del id en el objeto
	 * @return el id en tipo entero
	 */
	public int getIdLibro() {
		return idLibro;
	}

	/**
	 * Método para establecer el identificador único del libro.
	 * @param id forma en que se establece el nuevo identificador del libro.
	 */
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	/**
	 * Método para obtener el isbn del libro
	 * @return el isbn del libro
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Método para establecer el isbn del libro
	 * @param isbn el nuevo isbn del libro
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Método para obtener el título del libro
	 * @return el título del libro
	 */
	public String getTituloLibro() {
		return tituloLibro;
	}

	/**
	 * Método para establecer el título del libro
	 * @param tituloLibro el nuevo título del libro
	 */
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	/**
	 * Método para obtener el nombre del autor del libro
	 * @return el nombre del autor del libro
	 */
	public String getNombreAutorLibro() {
		return nombreAutorLibro;
	}

	/**
	 * Método para establecer el nombre del autor dellibro
	 * @param nombreAutorLibro el nuevo nombre del autor del libro
	 */
	public void setNombreAutorLibro(String nombreAutorLibro) {
		this.nombreAutorLibro = nombreAutorLibro;
	}

	/**
	 * Método para obtener el primer apellido del autor del libro
	 * @return el primer apellido del autor del libro
	 */
	public String getApellido1AutorLibro() {
		return apellido1AutorLibro;
	}

	/**
	 * Método para establecer el primer apellido del autor del libro
	 * @param apellido1AutorLibro el nuevo primer apellido del autor del libro
	 */
	public void setApellido1AutorLibro(String apellido1AutorLibro) {
		this.apellido1AutorLibro = apellido1AutorLibro;
	}

	/**
	 * Método para obtener el segundo apellido del autor del libro
	 * @return el segundo apellido del autor del libro
	 */
	public String getApellido2AutorLibro() {
		return apellido2AutorLibro;
	}

	/**
	 * Método para establecer el segundo apellido del autor del libro
	 * @param apellido2AutorLibro el nuevo segundo apellido del autor del libro
	 */
	public void setApellido2AutorLibro(String apellido2AutorLibro) {
		this.apellido2AutorLibro = apellido2AutorLibro;
	}

	/**
	 * Método para obtener el género del libro
	 * @return el género del libro
	 */
	public String getGeneroLibro() {
		return generoLibro;
	}

	/**
	 * Método para establecer el género del libro
	 * @param generoLibro el nuevo género del libro
	 */
	public void setGeneroLibro(String generoLibro) {
		this.generoLibro = generoLibro;
	}

	/**
	 * Método para obtener la psinosis del libro
	 * @return la psinopsis el libro
	 */
	public String getPsinopsis() {
		return psinopsis;
	}

	/**
	 * Método para establcer la psinopsis del libro
	 * @param psinopsis la nueva psinopsis del libro
	 */
	public void setPsinopsis(String psinopsis) {
		this.psinopsis = psinopsis;
	}

	/**
	 * Método para obtener la foto de portada del libro
	 * @return la foto de portada del libro
	 */
	public String getFotoPortada() {
		return fotoPortada;
	}

	/**
	 * Método para establecer la foto de portada del libro
	 * @param fotoPortada la nuvea foto de portada
	 */
	public void setFotoPortada(String fotoPortada) {
		this.fotoPortada = fotoPortada;
	}
	
	/**
	 * Método que inserta el objeto libro en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos. 
	 */
	public void insertarLibro () throws SQLException {
		DaoLibro.getInstance().insertarLibro(this);
	}
	
	/**
	 * Método para actualizar el objeto libro en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
	public void actualizar () throws SQLException {
		DaoLibro.getInstance().actualizar(this);
	}
	
	/**
	 * Método para borrar el objeto libro en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @param idLibro identificador único del libro
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
	public void borrar (int idLibro) throws SQLException {
		DaoLibro.getInstance().borrar(idLibro);
	}
	
	/**
	 * Método para obtener al libro por su id
	 * @param idLibro identificador único del libro
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
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
	
	/**
	 * Convierte el objeto libro a formato JSON
	 * @return una cadena de texto que representa este objeto en formato JSON
	 */
	public String dameJson() {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;
	}
	

	/**
	 * Método toString. Devuelve una representación de cadena del objeto libro. Esta representación 
	 * incluye los valores de todos los atributos del obteto. 
	 */
	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", isbn=" + isbn + ", tituloLibro=" + tituloLibro + ", nombreAutorLibro="
				+ nombreAutorLibro + ", apellido1AutorLibro=" + apellido1AutorLibro + ", apellido2AutorLibro="
				+ apellido2AutorLibro + ", generoLibro=" + generoLibro + ", psinopsis=" + psinopsis + ", fotoPortada="
				+ fotoPortada + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
