<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="./css/estilo.css">
<link rel="stylesheet" href="./css/estilo-tema-azul.css" id="link-tema">
</head>
<body>
    <header>
        <div id="logo">
            <img src="imagens/logo_azul.png">
            <span id="titulo">SGCM</span>
        </div>
    </header>
    <main>
        <h2>Login</h2>
        <form method="post" action="${pageContext.request.contextPath}/usuarioservlet">
            <label for="username">Usuário:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" class="botao" id="login" value="Login">
        </form>
    </main>
    <footer>
        <span>Telefone: (68) 2649-5578</span>
        <span>suporte.sgcm@gmail.com</span>
    </footer>
</body>
</html>
