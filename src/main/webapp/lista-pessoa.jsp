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
        <h1>Lista de pessoas</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="novaPessoa">Adicionar pessoa</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listaPessoa">Listar todos</a>         
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de pessoas</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Endereço</th>
                <th>UF</th>
                <th>E-Telefone</th>
                <th>Documento</th>
                <th>E-mail</th>
                <th>Opções</th>
            </tr>
            <c:forEach var="people" items="${listPeople}">
                <tr>
                    <td><c:out value="${people.idPessoa}" /></td>
                    <td><c:out value="${people.nomePessoa}" /></td>
                    <td><c:out value="${people.endereco}" /></td>
                    <td><c:out value="${people.uf}" /></td>
                    <td><c:out value="${people.telefone}" /></td>
                    <td><c:out value="${people.documento}" /></td>
                    <td><c:out value="${people.email}" /></td>
                    <td>
                        <a href="editaPessoa?idPessoa=<c:out value='${people.idPessoa}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="removePessoa?idPessoa=<c:out value='${people.idPessoa}' />">Remover</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>