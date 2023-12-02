<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/form.css">
<title>Denuncia</title>
</head>
<body>
<div class="container">
	<form action="denuncia" method="post">
		<h1>Confirme sua denúncia</h1>
		<span>Motivo da sua denúncia</span>
		<input name="motivo" type="radio" id="spoiler" value="spoiler">
		<label for="spoiler">Spoiler</label>
		<input name="motivo" type="radio" id="spam" value="spam">
		<label for="spam">Spam</label>
		<input name="motivo" type="radio" id="outro" value="outro">
		<label for="outro">Outro</label>
		<br> <button type="submit">Confirmar</button>
	</form>
</div>
</body>
</html>