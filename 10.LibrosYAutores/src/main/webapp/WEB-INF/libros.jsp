<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Libros</title>
</head>
<body>
    <h1>Catálogo de Libros</h1>
    
    
    <!--  Formulario de búsqueda -->
    <form action="/libros/buscar" method="GET">
        <input type="text" name="nombreLibro" placeholder="Escribe el nombre del libro..." required>
        <button type="submit">Buscar Libro</button>
    </form>
    <br>
    <ul>
        <c:forEach var="libro" items="${listaLibros}">
            <li>
                <a href="/libros/${libro}"><c:out value="${libro}"/></a>
            </li>
        </c:forEach>
    </ul>

    <br>
    <!-- Enlace para ir a la sección de agregar un nuevo libro -->
    <a href="/libros/formulario"><button>Agregar Nuevo Libro</button></a>
</body>
</html>
