window.addEventListener("DOMContentLoaded", function() {
    let fotoGrande = document.getElementById("fotoGrande");
    let cajaFotosPeques = document.getElementById("cajaFotosPeques");
    let flechaIzquierda = document.getElementById("flechaIzquierda");
    let flechaDerecha = document.getElementById("flechaDerecha");
    let rutas = [];
    let posicionActual = 0;

    function llamada() {
        fetch('GestionLibro?op=1')
            .then(response => response.json())
            .then(data => {
                pintarTabla(data);
                cargarImagenes(data);
            })
            .catch(error => console.error('Error:', error));
    }

    function borrar(idLibro) {
        if (confirm("Seguro que quieres borrar")) {
            fetch('GestionLibro?idLibro=' + idLibro + '&op=3')
                .then(response => response.json())
                .then(data => {
                    pintarTabla(data);
                    cargarImagenes(data);
                })
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
            html += "<p><a href='addLibros.html?idLibro=" + datos[i].idLibro + "&op=2'>Editar</a><a href='javascript:borrar(" + datos[i].idLibro + ")'>Borrar</a></p>";
            html += "</div>";
            html += "</div>";
        }

        document.getElementById("resultados").innerHTML = html;
    }

    function cargarImagenes(datos) {
        rutas = datos.map(libro => 'Image/' + libro.fotoPortada);
        cajaFotosPeques.innerHTML = '';
        datos.forEach((libro, index) => {
            let img = document.createElement("img");
            img.src = 'Image/' + libro.fotoPortada;
            img.alt = "Portada del libro";
            img.id = "foto" + (index + 1);
            img.addEventListener("click", function() {
                cambiarImagen(rutas[index]);
                posicionActual = index;
            });
            cajaFotosPeques.appendChild(img);
        });
        if (rutas.length > 0) {
            cambiarImagen(rutas[0]);
        }
    }

    function cambiarImagen(ruta) {
        fotoGrande.setAttribute("src", ruta);
    }

    function retroceder() {
        if (posicionActual === 0) {
            posicionActual = rutas.length - 1;
        } else {
            posicionActual--;
        }
        cambiarImagen(rutas[posicionActual]);
    }

    function avanzar() {
        if (posicionActual === rutas.length - 1) {
            posicionActual = 0;
        } else {
            posicionActual++;
        }
        cambiarImagen(rutas[posicionActual]);
    }

    flechaIzquierda.addEventListener("click", retroceder);
    flechaDerecha.addEventListener("click", avanzar);

    llamada();
});


















/*
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
        html += "<p><a href='addLibros.html?idLibro=" + datos[i].idLibro + "&op=2'>Editar</a><a href='javascript:borrar(" + datos[i].idLibro + ")'>Borrar</a></p>";
        html += "</div>";
        html += "</div>";
    }

    document.getElementById("resultados").innerHTML = html;
}

 window.onload = function() {
	
	    	llamada();
    }
*/


