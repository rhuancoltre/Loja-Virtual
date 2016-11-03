<%-- 
    Document   : admin
    Created on : 19/10/2016, 20:37:24
    Author     : Rhuan
--%>
<%@page import="java.util.List"%>
<%@page import="br.com.controller.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
%>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Administrador</title>
    </head>
    <body>
        <div>
            <button class="btn btn-warning"><a href="index.jsp">Home</a></button>
            <button class="btn btn-warning"><a href="cadproduto.jsp">CadProdutos</a></button>

            <div align="center">

                <table border="1" >
                    <tr>
                        <th>Código</th>
                        <th>Descrição</th>
                        <th>Informação</th>
                        <th>Valor</th>
                        <th>Alterar</th>
                        <th>Excluir</th>
                    </tr> 
                    <% if (produtos != null) {
                        for (Produto prod : produtos) {%>
                    <tr>
                        <td><%= prod.getId()%></td>
                        <td><%= prod.getDescricao()%></td>
                        <td><%= prod.getInformacao()%></td>
                        <td><%= prod.getValor()%></td>
                        <td><a href="/LojaVirtual/ServletProduto?acao=alterar&id=<%= prod.getId()%>"><b>Editar</b></a></td>
                        <td><a href="/LojaVirtual/ServletProduto?acao=excluir&id=<%= prod.getId()%>"><b>Excluir</b></a></td>
                    </tr> 
                </table>
                <% }
                    }%>
                <button class="btn btn-success"><a href="cadproduto.jsp">Novo</a></button>
            </div>
        </div>
    </body>
</html>
