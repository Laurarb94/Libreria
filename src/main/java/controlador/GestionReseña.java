package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Reseña;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class GestionReseña
 */
public class GestionReseña extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionReseña() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idReseña = request.getParameter("idReseña");
		String titulo = request.getParameter("titulo");
		String fechaReseña = request.getParameter("fechaReseña");
		int calificacionReseña = Integer.parseInt(request.getParameter("calificacionReseña"));
		String contenido = request.getParameter("contenido");
		String nombreUsuario = request.getParameter("nombreUsuario");
		
		Reseña r = new Reseña (titulo, fechaReseña, calificacionReseña, contenido, nombreUsuario);
		
		try {
			r.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("listarReseñas.html");
		
	}

		
		
		
		
		
	}


