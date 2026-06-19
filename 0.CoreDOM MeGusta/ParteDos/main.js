// Usamos variables numéricas separadas para controlar el click al boton
var likes1 = 0;
var likes2 = 0;
var likes3 = 0;

// --- Lógica de interacción para la Publicación 1 (Linn O.) ---
var boton1 = document.querySelector(".tarjeta1 .btn-like");
var contadorTexto1 = document.querySelector(".tarjeta1 .contarLikes");

boton1.addEventListener("click", function() {
    likes1++;
    contadorTexto1.innerText = likes1 + " like(s)";
});

// --- Lógica de interacción para la Publicación 2 (Lina K.) ---
var boton2 = document.querySelector(".tarjeta2 .btn-like");
var contadorTexto2 = document.querySelector(".tarjeta2 .contarLikes");

boton2.addEventListener("click", function() {
    likes2++;
    contadorTexto2.innerText = likes2 + " like(s)";
});

// --- Lógica de interacción para la Publicación 3 (Mateo H.) ---
var boton3 = document.querySelector(".tarjeta3 .btn-like");
var contadorTexto3 = document.querySelector(".tarjeta3 .contarLikes");

boton3.addEventListener("click", function() {
    likes3++;
    contadorTexto3.innerText = likes3 + " like(s)";
});