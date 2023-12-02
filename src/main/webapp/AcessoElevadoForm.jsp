<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String erro = request.getParameter("erro");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/form.css">
<title>Entrada de acesso elevado</title>
</head>
<body>
	<div class="container">
	<form action="entrarElevado" method="post">
		<h1>Acesso de nível elevado</h1>
		<% if(erro != null && erro.equals("1")){ %>
			<span class="msg-erro">Erro: Senha ou Email incorretos. Tente novamente.</span>
		<% } %>
		<label for="nivel_acesso">Nível de acesso</label>
		<select id="nivel_acesso" name="nivel_acesso">
			<option value="Moderador">Moderador</option>
			<option value="Administrador" selected>Administrador</option>
		</select><br>
		<label class="l" for="email">Email</label> <input type="email" id="email" name="email" required><br>
		<br> <label class="l" for="senha">Senha</label> <input type="password" id="senha" name="senha" required><br>
		<br> <button type="submit">Entrar</button>
	</form>
	<script>
	const emailInput = document.getElementById('email');
	const passwordInput = document.getElementById('senha');
	const errorSpan = document.querySelector('span.msg-erro');
	
	const hideError = () => {
	  if (emailInput.value && passwordInput.value) {
	    errorSpan.style.display = 'none';
	  }
	};
	
	emailInput.addEventListener('input', hideError);
	passwordInput.addEventListener('input', hideError);
	</script>
	</div>
</body>
</html>