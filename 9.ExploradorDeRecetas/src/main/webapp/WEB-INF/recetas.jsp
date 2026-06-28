<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- archivo recetas.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Recetas</title>
</head>
<body>
    <h1>Nuestras Recetas</h1>
    
    <ul>
        <!-- Recorremos el arreglo que enviamos desde el controlador -->
        <c:forEach var="receta" items="${listaRecetas}">
            <li>
                <!-- Creamos el enlace dinámico, ej: /recetas/Pizza -->
                <a href="/recetas/${receta}"><c:out value="${receta}"/></a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>