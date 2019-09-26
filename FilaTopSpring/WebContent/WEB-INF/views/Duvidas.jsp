<%@page import="mvc.model.Alunos"%>
<%@page import="mvc.model.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>Pagina de duvidas</title>

</head>
<h1 class="blue-text text-darken-4 card-panel teal lighten-2">FilinhaTop.io
<a href="/FilaTopSpring/cria" class="#ffab40 orange accent-2 waves-effect waves-light btn">Adicionar Duvida</a>

</h1>

<body>
	<%
	mvc.model.DAO dao = new DAO();
	List<Alunos> alunos = dao.getLista();
	for (Alunos aluno : alunos ) { %>
<div class="col s12 m7">
    <h2 class="header"> <%=aluno.getNome()%></h2>
    <div class="card horizontal">

      <div class="card-stacked">
        <div class="card-content">
		<p><%=aluno.getDuvida()%></p>
        </div>
        <div class="card-action">
     	<form action="removeDuvida" method="POST">
        	<!-- <input type="text" name="delete" value="DELETE"> -->
        	<input type="hidden" name="id" value="<%=aluno.getId()%>" >
        	<input class="btn waves-effect waves-light" type="submit" name="delete" value="DELETE" >
        </form>
        <form action="editaDuvida" method="POST">
        	<!-- <input type="text" name="delete" value="DELETE"> -->
        	<input type="hidden" name="nome" value="<%=aluno.getNome()%>">
        	<input type="hidden" name="duvida" value="<%=aluno.getDuvida()%>">
        	<input type="hidden" name="id" value="<%=aluno.getId()%>"> 	
        	<input class="btn waves-effect waves-light" type="submit" name="Editar" value="EDITAR">
        </form>
    	
        </div>
      </div>
    </div>
  </div>
  		 	 
<% } %>
    
</body>
</html>