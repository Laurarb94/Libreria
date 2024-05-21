window.addEventListener("DOMContentLoaded", function() {
	//Aquí referencio a los elementos del DOM. Se asegura que se cargue todo sólo cuando el contenido del DOM se haya cargado del todo 
	
    let fotoGrande = document.getElementById("fotoGrande");
    let tituloLibro = document.getElementById("tituloLibro");
    let autorLibro = document.getElementById("autorLibro");
    let generoLibro = document.getElementById("generoLibro");
    let psinopsisLibro = document.getElementById("psinopsisLibro");
    let cajaFotosPeques = document.getElementById("cajaFotosPeques");
    let flechaIzquierda = document.getElementById("flechaIzquierda");
    let flechaDerecha = document.getElementById("flechaDerecha");
    
    //hago un array para almacenar los libros obtenidos. Primero, let libros = [] está inicializando un array vacío para almacenar los datos de libros. 
    
    let libros = [];
    let posicionActual = 0;

    //Función para obtener los datos de los libros. Llamo al servlet donde gestiono los libros
    function llamada() {
        fetch('GestionLibro?op=1')
            .then(response => response.json())
            .then(data => {
                libros = data; //me guarda los libros en el array. 
                cargarImagenes(data); //llama a la función que carga las miniaturas de las portadas
                
                if (libros.length > 0) { //mmuestra el primer libro si hay libros disponibles. 
                    mostrarLibro(0);
                }
            })
            .catch(error => console.error('Error:', error));
    }


    //Función para borrar los libros
    function borrar(idLibro) {
        if (confirm("Seguro que quieres borrar")) {
            fetch('GestionLibro?idLibro=' + idLibro + '&op=3')
                .then(response => response.json())
                .then(data => {
                    libros = data; //actualiza el array de libros
                    cargarImagenes(data); //Recarga las miniaturas. 
                    
                    if (libros.length > 0) { //muestra el primer libro si hay libros disponibles
                        mostrarLibro(0);
                    } else { //si no hay libros, limpia la pantalla
                        limpiarLibroSeleccionado();
                    }
                })
                .catch(error => console.error('Error:', error));
        }
    }
    
    //Función para limpiar la visualización del libro que se ha seleccionado. Vacía todo, imágenes y datos del libro. 
    function limpiarLibroSeleccionado() {
        fotoGrande.src = '';
        tituloLibro.innerText = '';
        autorLibro.innerText = '';
        generoLibro.innerText = '';
        psinopsisLibro.innerText = '';
    }

    //Esta función va a mostrar la info específica de cada libro
    function mostrarLibro(index) {
        let libro = libros[index];
        fotoGrande.src = 'Image/' + libro.fotoPortada;
        tituloLibro.innerText = 'Título: ' + libro.tituloLibro;
        autorLibro.innerText = 'Autor: ' + libro.nombreAutorLibro + ' ' + libro.apellido1AutorLibro + ' ' + libro.apellido2AutorLibro;
        generoLibro.innerText = 'Género: ' + libro.generoLibro;
        psinopsisLibro.innerText = 'Psinopsis: ' + libro.psinopsis;
        posicionActual = index;
    }

    //Esta función va a cargar las miniaturas de las portadas 
    function cargarImagenes(datos) {
        cajaFotosPeques.innerHTML = '';
        datos.forEach((libro, index) => {
            let img = document.createElement("img");
            img.src = 'Image/' + libro.fotoPortada;
            img.alt = "Portada del libro";
            img.id = "foto" + (index + 1);
            img.addEventListener("click", function() {
                mostrarLibro(index); //cuando haga click me muestra el libro
            });
            cajaFotosPeques.appendChild(img); //añade la miniatura al contenedor
        });
    }

    function retroceder() {
        if (posicionActual === 0) {
            posicionActual = libros.length - 1;
        } else {
            posicionActual--;
        }
        mostrarLibro(posicionActual);
    }

    function avanzar() {
        if (posicionActual === libros.length - 1) {
            posicionActual = 0;
        } else {
            posicionActual++;
        }
        mostrarLibro(posicionActual);
    }

    flechaIzquierda.addEventListener("click", retroceder);
    flechaDerecha.addEventListener("click", avanzar);

    llamada();
});
















