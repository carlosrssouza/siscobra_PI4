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
        <h1>Pagamento</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="novoPagamento">Adicionar pagamento</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listaPagamento">Listar todos</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${payment != null}">
            <form action="atualizaPagamento" method="post">
            </c:if>
            <c:if test="${payment == null}">
                <form action="inserePagamento" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${payment != null}">
                                Editar
                            </c:if>
                            <c:if test="${payment == null}">
                                Adicionar pagamento
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${payment != null}">
                        <input type="hidden" name="idPagamento" value="<c:out value='${payment.idPagamento}' />" />
                    </c:if>            
                    <tr>
                        <th>Divida </th>
                        <td>
                            <input type="number" name="idDividaPagamento" size="45" min="1"
                                   value="<c:out value='${payment.idDividaPagamento}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Data </th>
                        <td>
                            <input type="text" name="dataPagamento" size="10"
                                   value="<c:out value='${payment.dataPagamento}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Valor </th>
                        <td>
                            <input type="number" name="valorPago" size="15" min="0.01" step="0.01"
                                   value="<c:out value='${payment.valorPago}' />"
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