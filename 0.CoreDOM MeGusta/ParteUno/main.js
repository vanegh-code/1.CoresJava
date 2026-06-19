console.log("connected");

// Seleccionamos el botón y el contenedor del texto del contador
var botonLike = document.querySelector(".like-btn");
var textoContador = document.querySelector(".like-count");

// creamos una variable para contar los likes
var cantidadLikes = 0;

// llamamos al evento de click en el botón amarillo
botonLike.addEventListener("click", function() {
    // Incrementamos el contador
    cantidadLikes++;
    
    // Actualizamos el texto en el HTML con cantidad
    textoContador.innerText = cantidadLikes + " like(s)";
});