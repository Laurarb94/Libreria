function llamada(idLibro, op){
			fetch('GestionLibro?idLibro='+idLibro+"&op="+op)
			.then(response => response.json())
			.then(data => pintarFormulario(data))
		
	}
		/**
 * Funci�n para otener el valor de un parametro en el GET 
 */
	function getParameterByName(name) {
		    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		    results = regex.exec(location.search);
		    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}

		
		function pintarFormulario(datos){
			document.getElementById("idLibro").value = datos.idLibro;
			document.getElementById("tituloLibro").value = datos.tituloLibro;
			document.getElementById("nombreAutorLibro").value = datos.nombreAutorLibro;
			document.getElementById("apellido1AutorLibro").value = datos.apellido1AutorLibro;
			document.getElementById("apellido2AutorLibro").value = datos.apellido2AutorLibro;
			document.getElementById("generoLibro").value = datos.generoLibro;
			document.getElementById("psinopsis").value = datos.psinopsis;

		}
		
		
		
		window.onload = function(){
			let idLibro = getParameterByName("idLibro");
			let op = getParameterByName("op");
			llamada(idLibro,op);
			
		}