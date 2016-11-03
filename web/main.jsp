<%@ page import="br.com.controller.LoginController" %>

<% if (LoginController.estaLogado(request)) { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Admin</title>
    </head>
    <body>
    </body>
</html>

<% } else {
        response.sendRedirect("/e-commerce");
    }
%>