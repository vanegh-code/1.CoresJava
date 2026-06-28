<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Libro</title>
</head>
<body>
<h1>Dar de Alta un Nuevo Libro</h1>

    <!-- El action apunta a la ruta que procesa el método POST -->
    <form action="/procesar/libro" method="POST">
        <div>
            <label for="nombreLibro">Nombre del Libro:</label>
            <input type="text" id="nombreLibro" name="nombreLibro" required>
        </div>
        <br>
        <div>
            <label for="nombreAutor">Autor:</label>
            <input type="text" id="nombreAutor" name="nombreAutor" required>
        </div>
        <br>
        <button type="submit">Guardar Libro</button>
    </form>

    <br>
    <a href="/libros">Regresar a la vista de todos los libros</a>
</body>
</html>