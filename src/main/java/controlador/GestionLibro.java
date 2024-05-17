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

import dao.DaoLibro;

/**
 * Servlet implementation class GestionLibro
 */

@MultipartConfig
public class GestionLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String pathFiles = "C:\\Documentos eclipse web\\Libreria\\src\\main\\webapp\\Image";
	private File upload = new File (pathFiles);
	
	
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
		
		PrintWriter out = response.getWriter();
		
		int opcion = Integer.parseInt(request.getParameter("op"));
		
		if(opcion == 2) {
			//lógica de edicion
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
			
			
		}else if (opcion == 1) {
			DaoLibro libros; 
			try {
				libros = new DaoLibro();
				out.print(libros.listarJson());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (opcion == 3) {
			try {
				int idLibro = Integer.parseInt(request.getParameter("idLibro"));
				DaoLibro libros = new DaoLibro();
				libros.borrar(idLibro);
				out.print(libros.listarJson());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
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
        String idLibro = request.getParameter("idLibro");
        
        //Primero hago la lectura en origen
        Part part = request.getPart("fotoPortada"); //me da los datos de la foto
        Path path = Paths.get(part.getSubmittedFileName()); //esto me da el nombre de archivo original
		String fileName = path.getFileName().toString();
		
		//Ya tengo la lectura en origen. Ahora hacemos el camnio a destino
		InputStream input = part.getInputStream();
		
		//Creo el contenedor
		File file = new File(upload, fileName);
		
			
		//Ya tenemos el origen y el camino. Queda meter lo que contenga esa lectura 
		//dentro del contenedor que hemos creado
		try {
		    Files.copy(input, file.toPath());
			System.out.println("Ruta de la imagen: "+file.getAbsolutePath());
			
		}catch (Exception e) {
			System.out.println("Error al copiar el archivo" +e.getMessage());
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			PrintWriter error = response.getWriter(); //para que salga el error por pantalla
			error.print("Se ha producido un error, contacte con el administrador");
		}
			
		
		
		Libro l; 
		
		try {
			l = new Libro (isbn, tituloLibro, nombreAutorLibro, apellido1AutorLibro,
					apellido2AutorLibro, generoLibro, psinopsis, fileName);
		
			if(idLibro == null || idLibro.trim().isEmpty()) {
				l.insertarLibro();
			}else {
				int idLibroInt = Integer.parseInt(idLibro);
				l.setIdLibro(idLibroInt);
				l.actualizar();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("catalogo.html");
		
	}
		
		
		
		
		
	}


