<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle del Libro</title>
</head>
<body>

    <c:choose>
        <c:when test="${encontrado}">
            <h1>Libro: <c:out value="${nombreLibro}"/></h1>
            <p><strong>Autor:</strong> <c:out value="${nombreAutor}"/></p>
        </c:when>
        <c:otherwise>
            <h2 style="color: red;"><c:out value="${mensajeError}"/></h2>
        </c:otherwise>
    </c:choose>

    <br>
    <a href="/libros">Regresar a la lista de todos los libros</a>

</body>
</html>