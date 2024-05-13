package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Libro;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * Servlet implementation class GestionLibro
 */

@MultipartConfig
public class GestionLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String pathFiles = "C:\\Documentos eclipse web\\Libreria\\src\\main\\webapp\\portada";
	private File uploads = new File (pathFiles);
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionLibro() {
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
		
		String isbn = request.getParameter("isbn");
		String tituloLibro = request.getParameter("tituloLibro");
		String nombreAutorLibro = request.getParameter("nombreAutorLibro");
		String apellido1AutorLibro = request.getParameter("apellido1AutorLibro");
		String apellido2AutorLibro = request.getParameter("apellido2AutorLibro");
		String generoLibro = request.getParameter("generoLibro");
        String psinopsis = request.getParameter("psinopsis");
        
        //Primero hago la lectura en origen
        Part part = request.getPart("fotoPortada"); //me da los datos de la foto
		Path path = Paths.get(part.getSubmittedFileName()); //esto me da el nombre de archivo original
		String fileName = path.getFileName().toString();
        
		//Ya tengo la lectura en origen. Ahora hacemos el camnio a destino
		InputStream input = part.getInputStream();
	
		File file = new File(uploads, fileName);
		
		//Ya tenemos el origen y el camino. Queda meter lo que contenga esa lectura 
		//dentro del contenedor que hemos creado
		try {
			Files.copy(input, file.toPath());
		}catch (Exception e) {
			System.out.println("Error al copiar el archivo");
			PrintWriter error = response.getWriter(); //para que salga el error por pantalla
			error.print("Se ha producido un error, contacte con el administrador");
		}
				
		Libro l = new Libro (isbn, tituloLibro, nombreAutorLibro, apellido1AutorLibro,
				apellido2AutorLibro, generoLibro, psinopsis, fileName);
	
		
		try {
			l.insertarLibro();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("catalogo.html");
		
	}
		
		
		
		
		
	}


