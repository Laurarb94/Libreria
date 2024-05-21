//Función para buscar
    function buscarPorTipo(tipo){
		console.log("está funcionando");
		fetch('GestionLibro?op=4&tipoLibro='+tipo)
                .then(response => response.json())
                .then(data => pintarTabla(data))
	}
	



function pintarTabla(data) {
    // Obtener el elemento donde se mostrará la lista de libros
    var listaLibros = document.getElementById("listaLibros");
    
    // Limpiar la lista de libros antes de agregar nuevos elementos
    listaLibros.innerHTML = "";
    
    // Crear elementos de lista para cada libro y agregarlos al contenedor
    data.forEach(function(libro) {
        var li = document.createElement("li");
        
        // Crear el elemento del título del libro
        var titulo = document.createElement("h3");
        titulo.textContent = libro.tituloLibro;
        li.appendChild(titulo);
        
        // Crear el elemento de la sinopsis del libro
        var sinopsis = document.createElement("p");
        sinopsis.textContent = libro.psinopsis;
        li.appendChild(sinopsis);
        
        // Crear el elemento de la imagen del libro
        if (libro.fotoPortada) {  // Asegurarse de que hay una URL de foto
            var imagen = document.createElement("img");
            imagen.src = "Image/" + libro.fotoPortada;  // Ruta relativa a la carpeta de imágenes
            imagen.alt = libro.tituloLibro;
            li.appendChild(imagen);
        }
        
        // Agregar el elemento de lista al contenedor
        listaLibros.appendChild(li);
    });
}














		
   /* 
	function pintarTabla(data) {
    // Obtener el elemento donde se mostrará la lista de libros
    var listaLibros = document.getElementById("listaLibros");
    
    // Limpiar la lista de libros antes de agregar nuevos elementos
    listaLibros.innerHTML = "";
    
    // Crear elementos de lista para cada libro y agregarlos al contenedor
    data.forEach(function(libro) {
        var li = document.createElement("li");
        var texto = document.createTextNode(libro.tituloLibro);
        
        li.appendChild(texto);
       
        listaLibros.appendChild(li);
    });
}

	*/
