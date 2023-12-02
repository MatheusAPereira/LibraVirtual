<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String erro = request.getParameter("erro"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Crie sua conta</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<div class="container">
        <form action="cadastrar" method="post" enctype=“multipart/form-data”>
        		<h1>Crie sua conta</h1>
        		<% if(erro!= null && erro.equals("1")) { %>
				<span class="msg-erro">Erro: O Email já foi cadastrado.</span>
				<% } %>
        		<img src="caminho_para_sua_imagem.jpg" alt="Descrição da imagem">
            	<input type="file" id="imagem" name="imagem"><br>
               	<br> <label for="nome" required>Nome</label>
                <input type="text" id="nome" name="nome"><br> 
                <label for="dataNascimento">Data de Nascimento</label> 
                <input type="date" id="dataNascimento" name="dataNascimento" required><br>
               	<label for="email">Email</label>
                <input type="email" id="email" name="email" required><br> 
                <label for="senha">Senha</label>
                <input type="password" id="senha" name="senha" required><br>
           
            <button type="submit">Criar</button><br>
            <span>Já tem conta? <a href="http://localhost:8080/LibraVirtual/UsuarioEntradaForm.jsp"> Crie uma aqui para entra.</a></span>
        </form>
    </div>

</body>
</html>