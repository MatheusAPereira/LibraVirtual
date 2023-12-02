<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Avaliação</title>
</head>
<body>
	<h1>Avaliação</h1>
	<form>
		<label for="comentario">Comentário:</label><br>
		<textarea id="comentario" name="comentario"></textarea><br>

		
		<input type="checkbox" id="spoiler" name="spoiler">
		<label for="spoiler">Este comentário contém spoiler</label><br><br>

		<input type="submit" value="Enviar">
	</form>
</body>
</html>