<%-- 
    Document   : naoEncontrada
    Created on : 8/Fev/2014, 17:23:10
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="utf-8">
        <title>Máquina não encontrada</title>
        <link href="libraries/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="myStyle.css" rel="stylesheet" media="screen">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="libraries/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="navbar transparent">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li><a role="" data-toggle="" class="navbar-text brand" href="">Máquina não encontrada</a></li>
                        <li class="navbar-text brand">|</li>
                        <li><a role="" data-toggle="" class="navbar-text brand">A máquina que encontraste ainda não foi registada.
                                <input type="text" class="span4" name="mail" placeholder="Mail" id='mail'>
                                <button type="submit" class="btn" onclick="return registaMail()"><span class="">Deixar o contacto</span></button>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>