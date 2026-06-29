<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detalle de cancion</h1>
	<p>${cancion.titulo}</p>
	<p>Artista: ${cancion.artista}</p>
	<p>Album: ${cancion.album}</p>
	<p>Genero: ${cancion.genero}</p>
	<p>Idioma: ${cancion.idioma}</p>
	
	<br>
    <a href="/canciones/formulario/editar/${cancion.id}">
        <button type="button">Actualizar Canción</button>
    </a>
    
    <br>
    <br>
    <form:form action="/canciones/eliminar/${cancion.id}" method="DELETE">
        <button type="submit" onclick="return confirm('¿Estás segura de eliminar esta canción?');" style="background-color: #ff4d4d; color: white;">
            Eliminar Canción
        </button>
    </form:form>
    <br>
    <br>
    
	<a href="/canciones">Volver a la lista de canciones</a>
</body>
</html>