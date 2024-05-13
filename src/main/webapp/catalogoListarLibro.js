/*
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
				html += "<td>"+datos[i].fotoPortada+"</td>";			
				html += "<td><a href='añadirLibros.html?idLibro="+datos[i].idLibro+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].idLibro+")'>Borrar</a></td>";
				html +="</tr>";
		}
		
		html +="</table>";
	
		document.getElementById("resultados").innerHTML = html;
	
			
	}
	


    window.onload = function() {
	
	    	llamada();
    }

*/





function llamada (){
    fetch('GestionLibro?op=1')
    .then(response => response.json ())
    .then (data => pintarLista(data))
}

function borrar(idLibro){
    if(confirm("Seguro que quieres borrar")){
        fetch('GestionLibro?idLibro='+idLibro+'&op=3')
        .then(response => response.json())
        .then(data => pintarLista(data))
    } else {
        
    }
}

function pintarLista (datos){
    const contenedorLibros = document.getElementById("resultados");
    contenedorLibros.innerHTML = ""; // Limpiar el contenido anterior
    
    datos.forEach(libro => {
        const libroDiv = document.createElement("div");
        libroDiv.classList.add("libro");
        
        const fotoDiv = document.createElement("div");
        fotoDiv.classList.add("foto");
        const foto = document.createElement("img");
        foto.src = "image/" + libro.fotoPortada;
        foto.alt = "Portada del libro";
        fotoDiv.appendChild(foto);
        libroDiv.appendChild(fotoDiv);
        
        const detallesDiv = document.createElement("div");
        detallesDiv.classList.add("detalles");
        const autor = document.createElement("h3");
        autor.textContent = libro.nombreAutorLibro;
        detallesDiv.appendChild(autor);
        const genero = document.createElement("p");
        genero.innerHTML = "<strong>Genero:</strong> " + libro.generoLibro;
        detallesDiv.appendChild(genero);
        const psinopsis = document.createElement("p");
        psinopsis.textContent = libro.psinopsis;
        detallesDiv.appendChild(psinopsis);
        libroDiv.appendChild(detallesDiv);
        
        const accionesDiv = document.createElement("div");
        accionesDiv.classList.add("acciones");
        const editarLink = document.createElement("a");
        editarLink.href = "añadirLibros.html?idLibro=" + libro.idLibro + "&op=2";
        editarLink.textContent = "Editar";
        accionesDiv.appendChild(editarLink);
        const borrarLink = document.createElement("a");
        borrarLink.href = "javascript:borrar(" + libro.idLibro + ")";
        borrarLink.textContent = "Borrar";
        accionesDiv.appendChild(borrarLink);
        libroDiv.appendChild(accionesDiv);
        
        contenedorLibros.appendChild(libroDiv);
    });
}


    window.onload = function() {
	
	    	llamada();
    }






















