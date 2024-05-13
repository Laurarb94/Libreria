function llamada (){
	fetch('GestionLibro?op=1')
	.then(response => response.json ())
	.then (data => pintarTabla(data))
}

function borrar(idLibro){
		
		if(confirm("Seguro que quieres borrar")){
			fetch('GestionLibro?idLibro='+idLibro+'&op=3')
			.then(response => response.json())
			.then(data => pintarTabla(data))
		}else{
			
		}
	}
	


function pintarTabla (datos){
	let html = "<table border='2' class='tablabonitadecss'>";
			
		for(let i=0;i<datos.length;i++){	
						
				html +="<tr><td>"+datos[i].idLibro+"</td>";
				html +="<td>"+datos[i].tituloLibro+"</td>";
				html +="<td>"+datos[i].nombreAutorLibro+"</td>";
				html +="<td>"+datos[i].apellido1AutorLibro+"</td>";
				html += "<td>"+datos[i].apellido2AutorLibro+"</td>";
				html += "<td>"+datos[i].generoLibro+"</td>";
				html += "<td>"+datos[i].psinopsis+"</td>";			
				html += "<td><a href='añadirLibros.html?idLibro="+datos[i].idLibro+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].idLibro+")'>Borrar</a></td>";
				html +="</tr>";
		}
		
		html +="</table>";
	
		document.getElementById("resultados").innerHTML = html;
	
			
	}
	


    window.onload = function() {
	
	    	llamada();
    }




/*
function cargarDatos() {
    // URL del servlet
    let url = "GestionLibro";
    
    // Realiza la llamada al servlet
    fetch(url)
    .then(response => response.json())
    .then(data => {
        // Cuando se reciben los datos, llama a la función para pintar los resultados
        pintarResultados(data);
    })
    .catch(error => {
        console.error('Error al cargar los datos:', error);
    });
}

function pintarResultados(datos) {
	console.log(datos);
    // Obtiene el contenedor donde se mostrarán los resultados
    const contenedor = document.getElementById("resultados");
    // Limpiar el contenedor antes de agregar los nuevos datos
    contenedor.innerHTML = "";

    // Itera sobre los datos y crea un elemento HTML para cada libro
    datos.forEach(libro => {
        const libroDiv = document.createElement("div");
        libroDiv.classList.add("libro");
        libroDiv.setAttribute("data-id", libro.idLibro); //agrego atributo id data para poder tener un id para función borrar
        
        libroDiv.innerHTML = `
            <div id="cajaFoto">
            <img src="image/${libro.fotoPortada}" id="foto" alt="Portada del libro">
            </div>
            <div id="cajaLibro">
                <div id="titulo"><h1>${libro.tituloLibro}</h1></div>
                <div id="autor"><h2>${libro.nombreAutorLibro}</h2></div>
                <div id="apellido1"><h2>${libro.apellido1AutorLibro}</h2></div>
                <div id="apellido2"><h2>${libro.apellido2AutorLibro}</h2></div>
                <div id="genero"><h3>${libro.generoLibro}</h3></div>
                <div id="psinopsis">${libro.psinopsis}</div>
            </div>
        `;
        
        // Agrega el elemento del libro al contenedor
        contenedor.appendChild(libroDiv);
    });
}

 window.onload = function(){
	 cargarDatos();
 }
*/