package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import dao.DaoUsuario;

/**
 * Servlet implementation class GestionUsuario
 */
public class GestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sesion;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		sesion = request.getSession(false);

		if(sesion != null){
			Object permisoObj = sesion.getAttribute("permiso");

			if(permisoObj instanceof Integer && (Integer)permisoObj == 9) {

				PrintWriter out = response.getWriter();

				int opcion = Integer.parseInt(request.getParameter("op"));

				if(opcion == 2) {
					//lógica edición

					int id = Integer.parseInt(request.getParameter("id"));
					Usuario u = new Usuario ();

					try {
						u.obtenerPorID(id);
						out.print(u.dameJson());
						System.out.println(u.dameJson());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}else if (opcion == 1) {
					DaoUsuario usuarios;
					try {
						usuarios = new DaoUsuario();
						out.print(usuarios.listarJson());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}else if(opcion == 3) {
					int id = Integer.parseInt(request.getParameter("id"));
					try {
						DaoUsuario usuarios = new DaoUsuario();
						usuarios.borrarUsario(id);
						System.out.println("Estoy borrando "+id);
						out.print(usuarios.listarJson());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}else {
				System.out.println("No puedes entrar");
				response.sendRedirect("formLogIn.html");
			}
		}else {
			System.out.println("No tienes permiso para acceder");
			response.sendRedirect("formLogIn.html");
		}





	}


		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		sesion = request.getSession(false); //previene la creación de una nueva sesión si no existe una
		
				String nombre = request.getParameter("nombre");
				String apellido1 = request.getParameter("apellido1");
				String apellido2 = request.getParameter("apellido2");
				int telefono = Integer.parseInt(request.getParameter("telefono"));
				int codPostal = Integer.parseInt(request.getParameter("codPostal"));
				String mail = request.getParameter("mail");
				int permiso = Integer.parseInt(request.getParameter("permiso"));
				String password = request.getParameter("password");
				String id = request.getParameter("id");
				
				//Uso este mapeo porque en un momento me dio error y no sabía de dónde venía
				Map<String, String[]> parameters = request.getParameterMap();
			    for(String parameter : parameters.keySet()) {
			        System.out.println("Parameter name: " + parameter);
			        System.out.println("Parameter value: " + Arrays.toString(parameters.get(parameter)));
			    }

				
				Usuario u; 
				try {
					u = new Usuario (nombre, apellido1, apellido2, telefono, codPostal, mail, permiso, password);
					
					if(id == null|| id.trim().isEmpty()) {
						DaoUsuario.getInstance().insertarUsuario(u);
						response.sendRedirect("pagPrincipalUsuario.html");
						
					}else {
						if(sesion !=null) {
							
							Object permisoObj = sesion.getAttribute("permiso");
							if (permisoObj instanceof Integer && (Integer) permisoObj == 9) {

								int idInt = Integer.parseInt(id);
								u.setId(idInt);
								u.actualizar();
								
								response.sendRedirect("listarUsuario.html");
							}
						}
					}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
		}
		
		
		
	}


