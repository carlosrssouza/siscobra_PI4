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
        <h1>Dívida</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="novaDivida">Adicionar dívida</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listaDivida">Listar todas</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${debt != null}">
            <form action="atualizaDivida" method="post">
            </c:if>
            <c:if test="${debt == null}">
                <form action="insereDivida" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${debt != null}">
                                Editar
                            </c:if>
                            <c:if test="${debt == null}">
                                Adicionar dívida
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${debt != null}">
                        <input type="hidden" name="idDivida" value="<c:out value='${debt.idDivida}' />" />
                    </c:if>            
                    <tr>
                        <th>Credor: </th>
                        <td>
                            <input type="number" name="idCredor" size="45" min="1"
                                   value="<c:out value='${debt.idCredor}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Data: </th>
                        <td>
                            <input type="text" name="dataAtualizacao" size="10"
                                   value="<c:out value='${debt.dataAtualizacao}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Valor </th>
                        <td>
                            <input type="number" name="valorDivida" size="15" min="0.01" step="0.01"
                                   value="<c:out value='${debt.valorDivida}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Devedor: </th>
                        <td>
                            <input type="number" name="idDevedor" size="15" min="1"
                                   value="<c:out value='${debt.idDevedor}' />"
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