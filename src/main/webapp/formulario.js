function llamada(id, op){
			fetch('GestionUsuario?id='+id+"&op="+op)
			.then(response => response.json())
			.then(data => pintarFormulario(data))
		
	}
	
 

 // Funcion para otener el valor de un parametro en el GET 
 function getParameterByName(name) {
		    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		    results = regex.exec(location.search);
		    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
		
	function pintarFormulario(datos){
		//Te ha costado tanto porque ponías el id aquí también. NO LO PONGAS. SI TIENES QUE PONERLO, BUSCA POR QUÉ NO FUNCIONA
		document.getElementById("id").value = datos.nombre;
		document.getElementById("nombre").value = datos.nombre;
		document.getElementById("apellido1").value = datos.apellido1;
		document.getElementById("apellido2").value = datos.apellido2;
		document.getElementById("telefono").value = datos.telefono;
		document.getElementById("codPostal").value = datos.codPostal;
		document.getElementById("mail").value = datos.mail;
		document.getElementById("permiso").value = datos.permiso;
		document.getElementById("password").value = datos.password;
	}
	

   		function validarFormulario(){
			   
		    let nombre = document.getElementById('nombre').value;
		    let apellido1 = document.getElementById('apellido1').value;
		    let apellido2 = document.getElementById('apellido2').value;
		    let telefono = document.getElementById('telefono').value;
		    let codPostal = document.getElementById('codPostal').value;
		    let email = document.getElementById('mail').value;
		    let permiso = document.getElementById('permiso').value;
		    let password = document.getElementById('password').value;
   		    

			let ok = true;
			if(nombre == ""){
				ok = false;
				document.getElementById('nombre').style.background = "red";
			}
			
			if(apellido1 == ""){
				ok = false;
				document.getElementById('apellido1').style.background = "red";
			}
			
			if(apellido2 == ""){
				ok = false;
				document.getElementById('apellido2').style.background = "red";
			}
			if(telefono == ""){
				ok = false;
				document.getElementById('telefono').style.background = "red";
			}
			
			if(codPostal == ""){
				ok = false;
				document.getElementById('codPostal').style.background = "red";
			}
			
			if(email == ""){
				ok = false;
				document.getElementById('mail').style.background = "red";
			}
			
			if(permiso == ""){
				ok = false; 
				document.getElementById('permiso').style.background = "red";
			}
			
			 if(ok == true){
					
					document.getElementById("password").style.background = "red";
					
				}
			
			if(ok == true){
				
				document.getElementById("altas").submit();
				
			}
			
				   
		}
   		
 
   		
   		window.onload = function(){
			let id = getParameterByName("id");
			let op = getParameterByName("op");
			llamada(id,op);
			
		}