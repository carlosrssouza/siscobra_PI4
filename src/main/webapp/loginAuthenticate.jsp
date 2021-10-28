<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SistemCobra - Sistema de Cobrança</title>
    </head>
    <body>
        <c:if test="${ empty param.username or empty param.password}">
            <c:redirect url="login.jsp" >
                <c:param name="errMsg" value="O usuario e a senha sao obrigatorios!" />
            </c:redirect>

        </c:if>

        <c:if test="${not empty param.username and not empty param.password}">
            <s:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
                             url="jdbc:mysql://localhost:3306/siscobdb?useSSL=false&serverTimezone=UTC"
                             user="root" password=""/>

            <s:query dataSource="${ds}" var="selectQ">
                select count(*) as kount from usuario
                where login='${param.username}'
                and senha='${param.password}'
            </s:query>

            <c:forEach items="${selectQ.rows}" var="r">
                <c:choose>
                    <c:when test="${r.kount gt 0}">
                        <c:set scope="session"
                               var="loginUser"
                               value="${param.username}"/>
                        <c:redirect url="index.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <c:redirect url="login.jsp" >
                            <c:param name="errMsg" value="Usuario ou senha invalido!" />
                        </c:redirect>
                    </c:otherwise>
                </c:choose>

            </c:forEach>

        </c:if>

    </body>
</html>