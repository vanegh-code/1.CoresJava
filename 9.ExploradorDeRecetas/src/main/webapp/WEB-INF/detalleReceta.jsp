<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle de la Receta</title>
</head>
<body>

    <c:choose>
		    <c:when test="${not empty ingredientes}">
            <h1>Receta: ${nombreReceta}</h1>
            <h3>Ingredientes:</h3>
            <ul>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <li>${ingrediente}</li>
                </c:forEach>
            </ul>
        </c:when>
        
  	        <c:otherwise>
            <h2 style="color: red;">${mensajeError}</h2>
        </c:otherwise>
    </c:choose>

    <br>
    <a href="/recetas">Volver a la lista de recetas</a>

</body>
</html>