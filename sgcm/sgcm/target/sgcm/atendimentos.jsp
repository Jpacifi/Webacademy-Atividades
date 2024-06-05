<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Atendimento"%>

<jsp:useBean id="controller" class="br.ufac.sgcm.controller.AtendimentoController" scope="page"/>

<% 
    List<Atendimento> registros = controller.processListRequest(request);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <title>SGCM - Atendimentos</title>
        <link rel="stylesheet" href="./css/estilo.css">
        <link rel="stylesheet" href="./css/estilo-tema-azul.css" id="link-tema">
        <script src="./js/script.js" defer></script>
        <script src="./js/atendimentos.js" defer></script>
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
            <div id="comandos">
                <a href="atendimentosForm.jsp" class="botao" id="add">Adicionar</a>
                <div>
                    <label for="busca">Busca</label>
                    <input type="search" name="busca" id="busca" placeholder="Digite para buscar">
                </div>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Data</th>
                        <th>Status</th>
                        <th>Convenio ID</th>
                        <th>Paciente ID</th>
                        <th>Profissional ID</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Atendimento item : registros) { %>
                    <tr>
                        <td class="fit"><%= item.getId() %></td>
                        <td><%= item.getData() %></td>
                        <td><%= item.getStatus() %></td>
                        <td><%= item.getConvenio_id() %></td>
                        <td><%= item.getPaciente_id() %></td>
                        <td><%= item.getProfissional_id() %></td>
                        <td>
                            <a class="botao" href="atendimentosForm.jsp?id=<%= item.getId() %>">Editar</a>
                            <a class="botao excluir" href="atendimentos.jsp?excluir=<%= item.getId() %>">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="7">Total de registros: <%= registros.size()%></td>
                    </tr>
                </tfoot>
            </table>
        </main>
        <footer>
            <span>SGCM - Sistema de Gerenciamento de Clínica Médica</span>
            <span>Telefone de contato: (68) 3333-3333 | <a href="mailto:suporte.sgcm@ufac.br">suporte.sgcm@ufac.br</a></span>
        </footer>
    </body>
</html>
