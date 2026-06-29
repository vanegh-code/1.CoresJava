<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista" />
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