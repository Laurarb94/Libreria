package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoUsuario;

public class Usuario {


	/**
	 * Representa el id del usuario
	 */
	private int id;
	/**
	 * Representa el nombre del usuario
	 */
	private String nombre; 
	/**
	 * Representa el primer apellido del usuario
	 */
	private String apellido1;
	/**
	 * Representa el segundo apellido del usuario
	 */
	private String apellido2;
	/**
	 * Representa el teléfono del usuario
	 */
	private int telefono; 
	/**
	 *Representa el código postal del usuario 
	 */
	private int codPostal;
	/**
	 * Representa el e-mail del usuario
	 */
	private String mail;
	/**
	 * Representa el permiso del usuario (pudienso ser 1, 5 o 9)
	 */
	private int permiso; 
	/**
	 * Representa la contraseña del usuario
	 */
	private String password;
	/**
	 * Constructor para generar un objeto vacío de tipo usuario
	 */
	public Usuario () {
		
	}
	
	/**
	 * Constructor para <strong>creación del objeto. Este constructor se usa cuando los datos van a la bbdd</strong>
	 * @param id identificador único del usuario
	 * @param nombre el nombre del usuario
	 * @param apellido1 el primer apellido del usuario
	 * @param apellido2 el segundo apellido del usuario
	 * @param telefono el teléfono del usuario
	 * @param codPostal el código postal del usuario
	 * @param mail el mail del usuario
	 * @param permiso el permiso del usuario
	 * @param password la contraseña del usuario
	 */

	public Usuario(int id, String nombre, String apellido1, String apellido2, int telefono, int codPostal, String mail,
			int permiso, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.codPostal = codPostal;
		this.mail = mail;
		this.permiso = permiso;
		this.password = password;
	}
	
	/**
	 * Constructor para <strong>creación del objeto. Este constructor se usa cuando los datos vienen de un formulario</strong>
	 * @param nombre el nombre del usuario
	 * @param apellido1 el primer apellido del usuario
	 * @param apellido2 el segundo apellido del usuario
	 * @param telefono el teléfono del usuario
	 * @param codPostal el código postal del usuario
	 * @param mail el mail del usuario
	 * @param permiso el permiso del usuario
	 * @param password la contraseña del usuario
	 */

	public Usuario(String nombre, String apellido1, String apellido2, int telefono, int codPostal, String mail,
			int permiso, String password) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.codPostal = codPostal;
		this.mail = mail;
		this.permiso = permiso;
		this.password = password;
	}
	
	/**
	 * Constructor para <strong>creación del objeto. Constructor sin contraseña.</strong>
	 * @param nombre el nombre del usuario
	 * @param apellido1 el primer apellido del usuario
	 * @param apellido2 el segundo apellido del usuario
	 * @param telefono el teléfono del usuario
	 * @param codPostal el código postal del usuario
	 * @param mail el mail del usuario
	 * @param permiso el permiso del usuario
	 */

	public Usuario(String nombre, String apellido1, String apellido2, int telefono, int codPostal, String mail,
			int permiso) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.telefono = telefono;
		this.codPostal = codPostal;
		this.mail = mail;
		this.permiso = permiso;
	}
	

	/**
	 * Método de inclusión del id en el objeto
	 * @return retorna el id en tipo entero
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para establecer el identificador único del usuario
	 * @param id forma en que se establece el nuevo identificador del usuario
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método para obtener el nombre del usuario
	 * @return el nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para establecer el nombre del usuario
	 * @param nombre el nuevo nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método para obtener el primer apellido del usuario
	 * @return el primer apellido del usuario
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Método para establecer el primer apellido del usuario
	 * @param apellido1 el nuevo primer apellido del usuario
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Método para obtener el segundo apellido del usuario
	 * @return el segundo apellido del usuario
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Método para establecer el segundo apellido del usuario
	 * @param apellido2 el nuevo segundo apellido del usuario
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	/**
	 * Método para obtener el teléfono del usuario
	 * @return el teléfono del usuario
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Método para establecer el teléfono del usuario
	 * @param telefono el nuevo teléfono del usuario
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método para obtener el código postal del usuario
	 * @return el código postal del usuario
	 */
	public int getCodPostal() {
		return codPostal;
	}

	/**
	 * Método para establecer el código postal del usuario
	 * @param codPostal el nuevo código postal del usuario
	 */
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	/**
	 * Método para obtener el mail del usuario
	 * @return el mail del usuario
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Método para establecer el mail del usuario
	 * @param mail el nuevo mail del usuario
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Método para obtener el permiso del usuario
	 * @return el permiso del usuario
	 */
	public int getPermiso() {
		return permiso;
	}

	/**
	 * Método para establecer el permiso del usuario
	 * @param permiso el nuevo permiso del usuario
	 */
	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
	
	/**
	 * Método para obtener la contraseña del usuario
	 * @return la contraseña del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Método para establecer el permiso del usuario
	 * @param password la nueva contraseña del usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Método toString. Devuelve una representación de cadena del objeto usuario. Esta representación 
	 * incluye los valores de todos los atributos del obteto. 
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", telefono=" + telefono + ", codPostal=" + codPostal + ", mail=" + mail + ", permiso=" + permiso
				+ ", password=" + password + "]";
	}
	
	/**
	 * Método que inserta el objeto usuario en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos. 
	 */
	public void insertarUsuario() throws SQLException {
		DaoUsuario.getInstance().insertarUsuario(this);
	}
	
	/**
	 * Método para obtener al usuario por el id
	 * @param id el id del usuario
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos. 
	 */
	public void obtenerPorID (int id) throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		Usuario aux = dao.obtenerPorID(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setApellido1(aux.getApellido1());
		this.setApellido2(aux.getApellido2());
		this.setTelefono(aux.getTelefono());
		this.setCodPostal(aux.getCodPostal());
		this.setMail(aux.getMail());
		this.setPermiso(aux.getPermiso());
	}
	
	/**
	 * Método para actualizar el objeto usuario en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
	public void actualizar () throws SQLException {
		DaoUsuario.getInstance().actualizar(this);
	}
	
	/**
	 * Convierte el objeto usuario a formato JSON
	 * @return una cadena de texto que representa este objeto en formato JSON
	 */
	public String dameJson() {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;
	}
	
	/**
	 * Método para borrar el objeto usuario en la base de datos. Utiliza el patrón Singleton para obtener la instancia Dao. 
	 * @param id identificador único del usuario
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
	public void borrarUsario (int id) throws SQLException {
		DaoUsuario.getInstance().borrarUsario(id);
	}
	
	/**
	 * Método que realiza un intento de inicio de sesión para el usuario con la contraseña que se ha proporcionado.
	 * @param password contraseña del usuario
	 * @return true si el inicio de sesión fue exitoso, false si no fue existoso. 
	 * @throws SQLException si ocurre un error al insertar el usuario en la base de datos.
	 */
	public boolean logueo(String password) throws SQLException {
		boolean ok = false;
		DaoUsuario dao = new DaoUsuario();
		Usuario aux = dao.logueando(this, password); //este es el que va a bbdd
		
		if(aux != null) {
			ok = true;
			this.setId(aux.getId());
			this.setNombre(aux.getNombre());
			this.setApellido1(aux.getApellido1());
			this.setApellido2(aux.getApellido2());
			this.setTelefono(aux.getTelefono());
			this.setCodPostal(aux.getCodPostal());
			this.setMail(aux.getMail());
			this.setPermiso(aux.getPermiso());
		}
		
		return ok;
	}

}
