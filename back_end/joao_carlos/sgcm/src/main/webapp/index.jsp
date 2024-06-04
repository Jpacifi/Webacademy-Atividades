<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGCM - Página Inicial</title>
<link rel="stylesheet" href="./css/estilo.css">
<link rel="stylesheet" href="./css/estilo-tema-azul.css" id="link-tema">
</head>
<body>
    <header>
        <div id="logo">
            <img src="imagens/logo_branco.png" alt="Logo SGCM">
            <span id="titulo">SGCM</span>
        </div>
        <div id="usuarioInfo">
            <span>Usuário: Administrador (admin)</span>
            <span>Papel: ADMIN</span>
            <select id="tema">
                <option value="">Escolha um tema</option>
                <option value="azul">Azul</option>
                <option value="vermelho">Vermelho</option>
                <option value="amarelo">Amarelo</option>
            </select>
        </div>
    </header>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="pacientes.jsp">Pacientes</a></li>
            <li><a href="atendimento.jsp">Atendimento</a></li>
            <li><a href="convenios.jsp">Convênios</a></li>
            <li><a href="profissionais.jsp">Profissionais</a></li>
            <li><a href="unidades.jsp">Unidades</a></li>
            <li><a href="especialidades.jsp">Especialidades</a></li>
            <li><a href="usuarios.jsp">Usuários</a></li>
        </ul>
    </nav>
    <main>
        <!-- Conteúdo principal da página -->
        <h1>Bem-vindo ao SGCM</h1>
        <p>Esta é a página inicial do Sistema de Gerenciamento de Clínica Médica.</p>
    </main>
    <footer>
        <span>SGCM - Sistema de Gerenciamento de Clínica Médica</span>
        <span>Telefone de contato: (68) 3333-3333 | <a href="mailto:suporte.sgcm@ufac.br">suporte.sgcm@ufac.br</a></span>
    </footer>
</body>
</html>
