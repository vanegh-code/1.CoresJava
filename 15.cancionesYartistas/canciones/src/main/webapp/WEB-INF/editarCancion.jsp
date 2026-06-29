<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Editar Canción</h1>
    
    <!-- formulario editar cancion-->
    <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
    <input type="hidden" name="_method" value="PUT" /> 
    <!-- iIMPORTANTE PARA ACTUALIZAR AGREGAR 3 COSAS ENLACE ISERROR EN JSP; ENLACE APP PROPERTIES Y HIDDEN METHOD USAT POT EN METHOD ACTION-->
        
        <!-- Mantenemos el ID oculto para que no se pierda en el objeto enviado -->
        <form:hidden path="id"/>

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
        <button type="submit">Actualizar Canción</button>
    </form:form>

    <br>
    <!-- Etiqueta de retorno a canciones -->
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>