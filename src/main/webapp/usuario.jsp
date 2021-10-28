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
        <h1>Usuário</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="novoUsuario">Adicionar usuário</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listaUsuario">Listar todos</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${user != null}">
            <form action="atualizaUsuario" method="post">
            </c:if>
            <c:if test="${user == null}">
                <form action="insereUsuario" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Editar
                            </c:if>
                            <c:if test="${user == null}">
                                Adicionar usuário
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${user != null}">
                        <input type="hidden" name="login" value="<c:out value='${user.login}' />" />
                    </c:if>            
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome" size="45"
                                   value="<c:out value='${user.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Cargo: </th>
                        <td>
                            <input type="text" name="cargo" size="45"
                                   value="<c:out value='${user.cargo}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Login: </th>
                        <td>
                            <input type="text" name="login" size="15"
                                   value="<c:out value='${user.login}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="password" name="senha" size="15"
                                   value="<c:out value='${user.senha}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>E-mail: </th>
                        <td>
                            <input type="email" name="email" size="15"
                                   value="<c:out value='${user.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salvar" />
                        </td>
                    </tr>
                </table>
            </form>
    </div> 
</body>
</html>