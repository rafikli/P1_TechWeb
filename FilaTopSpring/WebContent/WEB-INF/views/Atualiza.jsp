<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,mvc.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            
<head>
<meta charset="UTF-8">
<title>Duvidas</title>
</head>
<h1 class="blue-text text-darken-4 card-panel teal lighten-2">FilinhaTop.io
<a href="/FilaTopSpring/" class="#ffab40 orange accent-2 waves-effect waves-light btn">Ver Duvidas</a>
</h1>
<body>
<form action="atualizaDuvida" method="POST">
        <h2>Editar Duvida</h2>
        <label>Aluno</label>
        <input type="text" name="nome" value="${nome}">
        <br>
        <label>Duvida</label>
        <input type="text" name="duvida" value="${duvida}">
        <br>
        <input type="hidden" name="id" value="${id}">
                
        <input class="btn waves-effect waves-light" type="submit" value="Atualizar">
    </form>
</body>
</html>