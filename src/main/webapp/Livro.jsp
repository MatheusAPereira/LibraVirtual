<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Livro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Livro livro = (Livro) session.getAttribute("livro"); 
String user_id = String.valueOf(session.getAttribute("user_id"));
String user_type = String.valueOf(session.getAttribute("user_type"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><% if(livro != null) { out.print("Livro: "+livro.getTitulo()); } else {out.print("Não encontrado");}; %></title>
<link rel="stylesheet" type="text/css" href="css/livro.css">
<link rel="stylesheet" type="text/css" href="css/rating.css">
<link rel="stylesheet" href="css/bootstrap-icons.min.css">

<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	display: flex;
	flex-direction: column;
	align-items: stretch;
/* 	height: 50vh; */
	width: 100%;
	}
	
.livro {
	display : flex;
	justify-content: space-between;
	margin-bottom: 20px;
	align-items: center;
	min-width: 600px;
}

.capa {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.imagem_livro {
	width: 200px;
	height: 300px;
	object-fit: cover;
}

.info_livro {
	padding-left: 20px;
}

.info_livro p {
	margin: 0;
}

form {
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 4px;
}

.comentario {
	margin-bottom: 10px;
}

@media screen and (max-width: 600px) {
	.livro{
		flex-direction: column;
		min-width: 100%;
	}
}

</style>

</head>
<body>
<div class="container">
	<% if(livro == null) { %>
		<h2>Livro não foi encontrado encontrado</h2>
	<% } else { %>
	<h1><% out.print(livro.getTitulo()); %></h1>
	<div class="livro">
			<div class="capa">
				<img
					src="img/<% out.print(livro.getImgCapa()); %>"
					alt="<% out.print(livro.getTitulo()); %>" class="imagem_livro">
			</div>
			<div class="info_livro">
				<p>
					<strong>Autor:</strong> <% out.print(livro.getAutor()); %>
				</p>
				<p>
					<strong>Sinopse:</strong> <% out.print(livro.getSinopse()); %>
				</p>
				<p>
					<strong>Número de páginas:</strong> <% out.print(livro.getNumpag()); %>
				</p>
				<p>
					<strong>Idioma:</strong> <% out.print(livro.getIdioma()); %>
				</p>
				<p>
					<strong>Editora:</strong> <% out.print(livro.getEditora()); %>
				</p>
				<% SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		        String dataFormatada = formatador.format(livro.getDataPubli()); %>
				<p>
					<strong>Data da publicação:</strong> <% out.print(dataFormatada); %>
				</p>
				<p>
					<strong>Público Indicado:</strong> <% out.print(livro.getClassificacao()); %>
				</p>
				<p>
					<strong>ISBN (ISBN-13):</strong> <% out.print(livro.getISBN()); %>
				</p>
			</div>
	</div>


	<div class="perfil">
	
<!-- 	<label> <input type="submit" name="Adicionar aos Favoritos" -->
<!-- 		value="Adicionar aos Favoritos"> -->
<!-- 	</label> -->

<!-- 	<label> <input type="submit" -->
<!-- 		name="Adicionar à Lista de Leitura" -->
<!-- 		value="Adicionar à Lista de Leitura"> -->
<!-- 	</label> -->
	
		<h1><% out.print(livro.getNotaMedia()); %> <small>(<% out.print(livro.getNumAval()); %>)</small></h1>
		<h2>Obra-prima</h2>
		<div class="avaliacao">
			<span class="estrelas">⭐⭐⭐⭐⭐</span>
		</div><br>

<!-- 		<input type="submit" name="Avaliar" value="Avaliar"><br><br> -->


		<% if(user_type != null && user_type.equals("comum")) { %>
		<div id="avaliacao-usuario">
		<form id="avaliacao-usuario" action="salvarAvaliacao" method="post">
		<div id="notas">
        <input id="nota1" type="radio" name="nota" value="0.5">
        <label for="nota1">0,5</label>
        <input id="nota2" type="radio" name="nota" value="1.0">
        <label for="nota2">1,0</label>
        <input id="nota3" type="radio" name="nota" value="1.5">
        <label for="nota3">1,5</label>
        <input id="nota4" type="radio" name="nota" value="2.0">
        <label for="nota4">2,0</label>
        <input id="nota5" type="radio" name="nota" value="2.5">
        <label for="nota5">2,5</label>
        <input id="nota6" type="radio" name="nota" value="3.0">
        <label for="nota6">3,0</label>
        <input id="nota7" type="radio" name="nota" value="3.5">
        <label for="nota7">3,5</label>
        <input id="nota8" type="radio" name="nota" value="4.0">
        <label for="nota8">4,0</label>
        <input id="nota9" type="radio" name="nota" value="4.5">
        <label for="nota9">4,5</label>
        <input id="nota10" type="radio" name="nota" value="5.0">
        <label for="nota10">5,0</label>
        <input type="hidden" name="id_usuario" value="<% out.print(user_id); %>">
        <input type="hidden" name="id_livro" value="<% out.print(livro.getId()); %>">
        </div>
			<h3>Comentário</h3>
			<textarea id="comentario" rows="4" cols="50"></textarea>
			<label> <input type="checkbox" name="spoiler" value="true">
				Esse comentário possui spoiler
			</label>
			<button type="submit">Enviar</button>
		</form>
		</div>
		<% } %>
		
		
		<div class="ultima-avaliacao">
		<h2>Thainan Miranda</h2>
			<span class="estrelas">⭐⭐⭐⭐⭐</span> <span class="descricao">Obra-prima</span>
			<p>Gostaria de um livro mostrando o final de todos, gostaria de
				saber o que foi feito com aquele-que-não-deve-ser-nomeado. Mas
				sempre é emocionante acompanhar o Harry, Rony e Hermione e suas
				aventuras, como se fosse a primeira vez.</p>
			<label> <input type="submit" name="denunciar" value="denunciar">
			</label>

		</div>
	</div>
	<% } %>
</div>

</body>
</html>