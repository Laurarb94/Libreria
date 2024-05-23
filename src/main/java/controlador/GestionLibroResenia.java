package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Libro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoLibro;
import dao.DaoResenia;

/**
 * Servlet implementation class GestionLibroResenia
 */
public class GestionLibroResenia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sesion;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionLibroResenia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*sesion = request.getSession(false);
		
		if(sesion != null) {
			Object permisoObj = sesion.getAttribute("permiso");
			
			if(permisoObj instanceof Integer && (Integer) permisoObj == 9) {
				
				PrintWriter out = response.getWriter();
				
				int opcion = Integer.parseInt(request.getParameter("op"));
				
				if(opcion == 2) { //libro editar
					//lógica de edicion libro
					int idLibro = Integer.parseInt(request.getParameter("idLibro"));
					Libro l = new Libro();
					
					try {
						l.obtenerPorId(idLibro);
						out.print(l.dameJson());
						System.out.println(l.dameJson());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else if (opcion == 1) { //libro listar
					DaoLibro libros; 
					try {
						libros = new DaoLibro();
						out.print(libros.listarJson());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else if (opcion == 3) { //libro borrar
					try {
						int idLibro = Integer.parseInt(request.getParameter("idLibro"));
						DaoLibro libros = new DaoLibro();
						libros.borrar(idLibro);
						out.print(libros.listarJson());
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(opcion == 4) { //Reseña listar
					try {
						DaoResenia resenia = new DaoResenia();
						out.print(resenia.listarJson());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(opcion == 5) { //Reseña borrar
					int id = Integer.parseInt(request.getParameter("id"));
					try {
						DaoResenia resenia = new DaoResenia();
						resenia.borrar(id);
						System.out.println("Estoy borrando "+id);
						out.print(resenia.listarJson());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					}
				
				
			}
			*/
		}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
