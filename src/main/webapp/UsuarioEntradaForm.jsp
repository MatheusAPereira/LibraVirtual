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
<title>Entre com sua conta</title>

</head>
<body>
<div class="container">
	<form action="entrar" method="post">
		<h1>Entre com sua conta</h1>
		<% if(erro != null && erro.equals("1")){ %>
			<span class="msg-erro">Erro: Senha ou Email incorretos. Tente novamente.</span>
		<% } %>
		<label for="email">Email</label> <input type="email" id="email" name="email" required><br>
		<br> <label for="senha">Senha</label> <input type="password" id="senha" name="senha" required><br>
		<br> <button type="submit">Entrar</button>
		<p>Não tem? <a href="UsuarioForm.jsp">Crie uma nova conta aqui.</a></p>
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