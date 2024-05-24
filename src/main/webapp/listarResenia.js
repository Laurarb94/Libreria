window.addEventListener("DOMContentLoaded", function() {
    function llamada(){
        fetch('GestionResenia?op=1')
            .then(response => response.json())
            .then(data => pintarTabla(data));
    }


    function pintarTabla(datos){
        let contenedor = document.getElementById("listado");
        contenedor.innerHTML = ""; // Limpiamos el contenido anterior

        for(let i = 0; i < datos.length; i++){    
            let cuadrado = document.createElement("div");
            cuadrado.classList.add("cuadrado");

            let nombreLibro = document.createElement("div");
            nombreLibro.classList.add("nombre-libro");
            nombreLibro.textContent = "Título del libro: " + datos[i].titulo;

            let fecha = document.createElement("div");
            fecha.classList.add("fecha");
            fecha.textContent = "Fecha de la reseña: " + datos[i].fecha;

            let calificacion = document.createElement("div");
            calificacion.classList.add("calificacion");
            calificacion.textContent = "Calificación del libro: " + datos[i].calificacion;

            let contenido = document.createElement("div");
            contenido.classList.add("contenido");
            contenido.textContent = "Reseña: " + datos[i].contenido;

            let nombreUsuario = document.createElement("div");
            nombreUsuario.classList.add("nombre-usuario");
            nombreUsuario.textContent = "Nombre del usuario: " + datos[i].nombreEscribeResenia;

            let borrar = document.createElement("div");
            let enlaceBorrar = document.createElement("a");
            enlaceBorrar.textContent = "Borrar";
            enlaceBorrar.href = "#";
            enlaceBorrar.addEventListener("click", function(){
                borrar(datos[i].id);
            });
            borrar.appendChild(enlaceBorrar);

            cuadrado.appendChild(nombreLibro);
            cuadrado.appendChild(fecha);
            cuadrado.appendChild(calificacion);
            cuadrado.appendChild(contenido);
            cuadrado.appendChild(nombreUsuario);
            cuadrado.appendChild(borrar);

            contenedor.appendChild(cuadrado);
        }
    }

    
     window.onload = function() {
	
	    	llamada();
    }


});

