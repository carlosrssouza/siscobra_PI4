<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SistemCobra - Sistema de Cobrança</title>
    </head>
    <body>
        <center>
            <h1>SistemCobra - Sistema de Cobrança</h1>
            <h2>Informe o usuário e a senha</h2>
            <h3><font color="red"><c:if test="${not empty param.errMsg}"><c:out value="${param.errMsg}" /></c:if></font>                    
            </h3>
        </center>
        <div align="center">
            <form action="loginAuthenticate.jsp" >
                <table border="0" cellpadding="5">
                    <tr>
                        <th align="left">Usuário: </th>
                        <td>
                            <input type="text" name="username"/><br/>
                        </td>
                    </tr>
                    <tr>
                        <th align="left">Senha: </th>
                        <td>
                            <input type="password" name="password"/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" value="Entrar" />
                        </td>
                    </tr>
                </table>                
            </form>
        </div>
    </body>
</html>