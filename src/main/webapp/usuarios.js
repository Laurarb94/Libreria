function llamada(){
		fetch('GestionUsuario?op=1')
		.then(response => response.json())
		.then(data => pintarTabla(data))
		
	}
	
	function borrar(id){
		
		if(confirm("Seguro que quieres borrar")){
			fetch('GestionUsuario?id='+id+'&op=3')
			.then(response => response.json())
			.then(data => pintarTabla(data))
		}else{
			
		}
	}
	
	function pintarTabla(datos){
		
		let html = "<table border='2' class='tablabonitadecss'>";
			
		for(let i=0;i<datos.length;i++){	
						
				html +="<tr><td>"+datos[i].id+"</td>";
				html +="<td>"+datos[i].nombre+"</td>";
				html +="<td>"+datos[i].apellido1+"</td>";
				html +="<td>"+datos[i].apellido2+"</td>";
				html += "<td>"+datos[i].telefono+"</td>";
				html += "<td>"+datos[i].codPostal+"</td>";
				html += "<td>"+datos[i].mail+"</td>";			
				html += "<td><a href='formularioInscripcion.html?id="+datos[i].id+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].id+")'>Borrar</a></td>";
				html +="</tr>";
		}
		
		html +="</table>";
	
		document.getElementById("listado").innerHTML = html;
	
			
	}
	
	
	function busquedaPorTipo(tipoUsuario){
		
		fetch('GestionUsuario?op=4&tipoUsuario='+tipoUsuario)
			.then(response => response.json())
			.then(data => pintarTabla(data))
		
	}
	

    window.onload = function() {
	
	    	llamada();
    }