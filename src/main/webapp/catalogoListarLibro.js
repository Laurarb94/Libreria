
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
			//	html += "<td>"+datos[i].apellido2AutorLibro+"</td>";
			//	html += "<td>"+datos[i].generoLibro+"</td>";
			//	html += "<td>"+datos[i].psinopsis+"</td>";
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


	

























