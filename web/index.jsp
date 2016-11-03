<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/includes/head.jsp" %>
        <title>E-Commerce</title>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <div class="account-wall">
                    <img class="profile-img" src="img/profile.jpg" alt="">
                    <form class="form-signin" action="ServletLogin" method="POST">
                        <input type="text" class="form-control" placeholder="Usuário" name="usuario" autofocus required>
                        <input type="password" class="form-control" placeholder="Senha" name="senha" required>
                        <button class="btn btn-lg btn-danger btn-block" type="submit">Entrar</button>
                    </form>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/app.js"></script>
    </body>
</html>