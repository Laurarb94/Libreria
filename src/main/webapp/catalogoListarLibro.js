function llamada() {
    fetch('GestionLibro?op=1')
        .then(response => response.json())
        .then(data => pintarTabla(data))
        .catch(error => console.error('Error:', error));
}

function borrar(idLibro) {
    if (confirm("Seguro que quieres borrar")) {
        fetch('GestionLibro?idLibro=' + idLibro + '&op=3')
            .then(response => response.json())
            .then(data => pintarTabla(data))
            .catch(error => console.error('Error:', error));
    }
}

function pintarTabla(datos) {
    let html = "";

    for (let i = 0; i < datos.length; i++) {
        html += "<div class='libro-item'>";
        html += "<div class='libro-imagen'>";
        html += "<img src='Image/" + datos[i].fotoPortada + "' alt='Portada' />";
        html += "</div>";
        html += "<div class='libro-detalles'>";
        html += "<p><strong>Título:</strong> " + datos[i].tituloLibro + "</p>";
        html += "<p>Nombre del Autor/a:" + datos[i].nombreAutorLibro + " " + datos[i].apellido1AutorLibro + "</p>";
        html += "<p>Género del libro:" + datos[i].generoLibro + "</p>";
        html += "<p>Psinopsis:" + datos[i].psinopsis + "</p>";
        html += "<p><a href='addLibros.html?idLibro=" + datos[i].idLibro + "&op=2'>Editar</a> | <a href='javascript:borrar(" + datos[i].idLibro + ")'>Borrar</a></p>";
        html += "</div>";
        html += "</div>";
    }

    document.getElementById("resultados").innerHTML = html;
}

 window.onload = function() {
	
	    	llamada();
    }



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
						
			//	html +="<tr><td>"+datos[i].idLibro+"</td>";
				html +="<td>"+datos[i].tituloLibro+"</td>";
				html +="<td>"+datos[i].nombreAutorLibro+"</td>";
				html +="<td>"+datos[i].apellido1AutorLibro+"</td>";
				html += "<td>"+datos[i].apellido2AutorLibro+"</td>";
				html += "<td>"+datos[i].generoLibro+"</td>";
				html += "<td>"+datos[i].psinopsis+"</td>";
			    html += "<td><img src='Image/" + datos[i].fotoPortada + "' alt='Portada' /></td>";				
				html += "<td><a href='addLibros.html?idLibro="+datos[i].idLibro+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].idLibro+")'>Borrar</a></td>";
				html +="</tr>";
		}
		
		html +="</table>";
	
		document.getElementById("resultados").innerHTML = html;
	
			
	}
	


    window.onload = function() {
	
	    	llamada();
    }

*/
	

























