<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastre um livro</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<div class="container">
<form id="formulario" action="cadastrarLivro" method="post">
	<h1>Cadastre um livro</h1>
		<label for="imagem">Imagem de capa</label>
		<input type="text" id="imagem" name="imagem"><br>

		<label for="isbn">ISBN</label>
		<input type="text" id="isbn" name="isbn" required><br>

		<label for="titulo">Título</label>
		<input type="text" id="titulo" name="titulo" required><br>

		<label for="sinopse">Sinopse</label>
		<textarea id="sinopse" name="sinopse" required></textarea><br>

		<label for="num_paginas">Número de páginas</label>
		<input type="number" id="num_paginas" name="num_paginas" min="1" max="9999" required><br>

		<label for="idioma">Idioma</label>
		<select id="idioma" name="idioma">
			<option value="portugues" selected>Português</option>
			<option value="ingles">Inglês</option>
			<option value="espanhol">Espanhol</option>
		</select>

		<label for="editora">Editora</label>
		<input type="text" id="editora" name="editora" required><br>

		<label for="data_publicacao">Data de publicação</label>
		<input type="date" id="data_publicacao" name="data_publicacao" required><br>

		<label for="autor">Autor</label>
		<input type="text" id="autor" name="autor" required><br>

		<label for="genero">Gênero</label>
		<select id="genero" name="genero">
			<option value="ficcao">Ficção</option>
			<option value="suspense">Suspence</option>
			<option value="romance">Romance</option>
			<option value="autoajuda">Autoajuda</option>
			<option value="misterio">Mistério</option>
			<option value="outro" selected>Outro</option>
		</select><br>

		<label for="classificacao_indicativa">Público indicado</label>
		<select id="classificacao_indicativa" name="classificacao">
			<option value="infantil">Infantil</option>
			<option value="adolecente">Adolescente</option>
			<option value="adulto">Adulto</option>
			<option value="todos" selected>Todos os públicos</option>
		</select><br><br>

		<button type="button" onclick="document.getElementById('formulario').reset()">Limpar</button>
		<button type="submit">Salvar</button>
	</form>
	</div>
</body>
</html>