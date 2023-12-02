<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.Livro"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% List<Livro> livros = (List<Livro>) request.getAttribute("livros"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/form.css">
<title>Pesquisa</title>
<style>
<style>
.container {
    width: 100%;
    padding: 20px;
    box-sizing: border-box;
}

* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

/* Estabelece o width das colunas */
.table {
    width: 100%;
    border-collapse: collapse;
}

/* Define as cores das linhas pares e impares */
tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:nth-child(odd) {
    background-color: #ffffff;
}
</style>
</head>
<body>
	<div class="container">
	<form action="pesquisar" method="Get">
		<label for="genero">Filtrar por gênero:</label>
		<select id="genero" name="genero">
			<option value="" selected>Todos</option>
			<option value="ficcao">Ficção</option>
			<option value="autoajuda">Autoajuda</option>
			<option value="romance">Romance</option>
		</select>
		<input type="text" id="pesquisa" name="q">
		<button type="submit">Pesquisar</button>
	</form>
	<br><br>

        <h2>Resultado: ${q} </h2><br>

		<% if(!livros.isEmpty()){ %>
        <table class="table">
            <tr>
                <td>Titulo</td>
                <td>Autor</td>
                <td>Nota media</td>
                <td>Numero de avaliação</td>
            </tr>
            <% for (Livro livro : livros) { %>
            <tr>
                <td><a href="Livro?id=<% out.print(livro.getId()); %>"><% out.print(livro.getTitulo()); %></a></td>
                <td><% out.print(livro.getAutor()); %></td>
                <td>00</td>
                <td>00</td>
            </tr>
            <% } %>
            <% } else { %>
            <h3>Nenhum resultado encontrado</h3>
            <% } %>

        </table>
    </div>
</body>
</html>