package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoUsuario;

public class Usuario {


	private int id; 
	private String nombre; 
	private String apellido1;
	private String apellido2;
	private int telefono; 
	private int codPostal;
	private String mail;
	private int permiso; 
	private String password;
	
	public Usuario () {
		
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", telefono=" + telefono + ", codPostal=" + codPostal + ", mail=" + mail + ", permiso=" + permiso
				+ ", password=" + password + "]";
	}
	
	public void insertarUsuario() throws SQLException {
		DaoUsuario.getInstance().insertarUsuario(this);
	}
	
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
	
	public void actualizar () throws SQLException {
		DaoUsuario.getInstance().actualizar(this);
	}
	
	public String dameJson() {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;
	}
	
	public void borrarUsario (int id) throws SQLException {
		DaoUsuario.getInstance().borrarUsario(id);
	}
	
	
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
