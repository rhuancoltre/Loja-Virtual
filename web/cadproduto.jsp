<%-- 
    Document   : cadproduto
    Created on : 21/10/2016, 02:25:37
    Author     : Rhuan
--%>
<%@page import="br.com.controller.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>Cadastro de Produtos</title>
    </head>
    <body> 
        <a href="index.jsp">Home</a>
        <a href="admin.jsp">Admin</a>
        <br />

        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 align="center">Cadastrar Produtos</h1>
            <form action="ServletProduto" method="POST">
                <input type="hidden" name="id" value="" />
                <input type="text" name="descricao" class="form-control" placeholder="Descrição" value="" />
                <br />
                <input type="text" name="informacao" class="form-control" placeholder="Informação" value="" />
                <br />
                <input type="text" name="valor" class="form-control" placeholder="Valor" value="" />
                <br />
                <input type="text" name="qtde" class="form-control" placeholder="Quantidade" value="" />
                <br />
                <div align="center">
                    <input type="submit" value="Cadastrar" class="btn btn-primary"/>
                    <input type="reset" value="Limpar Campos" class="btn btn-danger"/>
                </div>
            </form>
        </div>

    </body>
</html>
