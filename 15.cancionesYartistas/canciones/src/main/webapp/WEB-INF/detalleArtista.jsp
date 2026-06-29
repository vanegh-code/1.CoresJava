<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle del Artista</title>
</head>
<body>
    <h1>Detalle del Artista</h1>
    <p><strong>Nombre:</strong> ${artista.nombre}</p>
    <p><strong>Apellido:</strong> ${artista.apellido}</p>
    <p><strong>Biografía:</strong> ${artista.biografia}</p>
    
    <h3>Canciones de este Artista</h3>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
            <li>${cancion.titulo} (Álbum: ${cancion.album})</li>
        </c:forEach>
        <c:if test="${empty artista.canciones}">
            <li>Este artista aún no tiene canciones registradas.</li>
        </c:if>
    </ul>
    
    <br><br>
    <!-- Enlace requerido para regresar a la lista -->
    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>