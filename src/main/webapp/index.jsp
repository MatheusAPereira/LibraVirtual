<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>LibraVirtual</title>
	<link rel="stylesheet" href="css/form.css">
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
	<%
	if(session != null && session.getAttribute("user_id") != null) {
	%>
		<h1>Olá, ${sessionScope.user_name}!</h1>
	<%
	} else {
	%>
		<h1>Usuário deslogado!</h1>
	<%
	}
	%>
	<a href="/LibraVirtual/UsuarioEntradaForm.jsp">Entrar</a>
	<a href="/LibraVirtual/UsuarioForm.jsp">Criar conta</a>
	<% if(session != null && session.getAttribute("user_type") != null) { %>
		<a href="/LibraVirtual/sair">Sair</a>
	<% } %>
	
	<% if(session != null && session.getAttribute("user_type") != null
			&& (session.getAttribute("user_type").equals("administrador") || session.getAttribute("user_type").equals("moderador"))) { %>
		<button onclick="window.location.href='LivroForm.jsp'">Adicionar livro</button>
	<% } %>
	<br><br>
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

        <h2>Melhor avaliados</h2><br>
        <!-- Cria uma tabela com 3 colunas e 5 linhas -->

        <table class="table">
            <tr>
                <td>Titulo</td>
                <td>Autor</td>
                <td>Nota media</td>
                <td>Numero de avaliação</td>
            </tr>
            <tr>
                <td>Linha 2</td>
                <td>Linha 2</td>
                <td>Linha 2</td>
                <td>Linha 2</td>
            </tr>
        </table>
        <br><br>
        <h2>Populares</h2><br>
        <!-- Cria uma tabela com 3 colunas e 5 linhas -->

        <table class="table">
            <tr>
                <td>Titulo</td>
                <td>Autor</td>
                <td>Nota media</td>
                <td>Numero de avaliação</td>
            </tr>
            <tr>
                <td>Linha 2</td>
                <td>Linha 2</td>
                <td>Linha 2</td>
                <td>Linha 2</td>
            </tr>
        </table>
    </div>
</body>
</html>
