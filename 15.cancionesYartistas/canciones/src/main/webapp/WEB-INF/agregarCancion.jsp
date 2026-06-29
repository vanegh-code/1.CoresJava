<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Cancion</title>
<style>.error { color: red; }</style>
</head>
<body>
<h1>Agregar Nueva Canción</h1>
    
    <!-- Formulario -->
    <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
        <div>
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" />
            <form:errors path="titulo" cssClass="error" />
        </div>
        <br>
        <div>
            <form:label path="artista.id">Artista:</form:label>
            <form:select path="artista.id">
                <form:option value="" label="-- Selecciona un artista --" />
                <c:forEach var="art" items="${listaArtistas}">
                    <form:option value="${art.id}">${art.nombre} ${art.apellido}</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="artista" cssClass="error" />
        </div>
        <br>
        <div>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" />
            <form:errors path="album" cssClass="error" />
        </div>
        <br>
        <div>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" />
            <form:errors path="genero" cssClass="error" />
        </div>
        <br>
        <div>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" />
            <form:errors path="idioma" cssClass="error" />
        </div>
        <br>
        <button type="submit">Guardar Canción</button>
    </form:form>

    <br>
    <!-- Etiqueta de retorno requerida -->
    <a href="/canciones">Volver a lista de canciones</a>

</body>
</html>