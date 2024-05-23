package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Resenia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoResenia;

/**
 * Servlet implementation class GestionResenia
 */
public class GestionResenia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sesion;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionResenia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		int opcion = Integer.parseInt(request.getParameter("op"));

		if (opcion == 1) {
			try {
				DaoResenia resenia = new DaoResenia();
				out.print(resenia.listarJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			if(sesion != null) { //Esto para que sólo pueda borrar admin
				Object permisoObj = sesion.getAttribute("permiso");

				if(permisoObj instanceof Integer && (Integer)permisoObj == 9){

				}else if(opcion == 2) {
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


			}*/


		}
			
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");
		int calificacion = Integer.parseInt(request.getParameter("calificacion"));
		String contenido = request.getParameter("contenido");
	    String nombreEscribeResenia = request.getParameter("nombreEscribeResenia");
	    String id = request.getParameter("id");
	    
	    Resenia r; 

	    try {
	    	r = new Resenia (titulo,fecha, calificacion, contenido, nombreEscribeResenia);

	    	if(id == null | id.trim().isEmpty()) {
	    		DaoResenia.getInstance().insertar(r);
	    		response.sendRedirect("listarResenia.html");
	    	}
	    } catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
		
		
	}

}
