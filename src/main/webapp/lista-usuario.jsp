<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty sessionScope['loginUser']}">
    <c:redirect url="login.jsp" />
</c:if>

<html>
    <head>
        <title>SistemCobra - Sistema de Cobrança</title>
    </head>
    <body>
    <center>
        <h1>Lista de usuários</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="novoUsuario">Adicionar usuário</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listaUsuario">Listar todos</a>         
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de usuários</h2></caption>
            <tr>
                <th>Nome</th>
                <th>Cargo</th>
                <th>Login</th>
                <th>Senha</th>
                <th>E-mail</th>
                <th>Opções</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.nome}" /></td>
                    <td><c:out value="${user.cargo}" /></td>
                    <td><c:out value="${user.login}" /></td>
                    <td><c:out value="${user.senha}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td>
                        <a href="editaUsuario?login=<c:out value='${user.login}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="removeUsuario?login=<c:out value='${user.login}' />">Remover</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>