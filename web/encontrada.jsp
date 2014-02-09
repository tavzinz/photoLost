<%-- 
    Document   : encontrada
    Created on : 8/Fev/2014, 17:22:47
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="utf-8">
        <title>Máquina encontrada</title>
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
                        <li><a role="" data-toggle="" class="navbar-text brand" href="">Máquina encontrada</a></li>
                        <li class="navbar-text brand">|</li>
                        <li><a role="" data-toggle="" class="navbar-text brand">Escolhe o que queres fazer:
                                <button type="submit" data-toggle="modal" class="btn" href="#modal_devolve_fotos"><span class="">Devolver fotos</span></button>
                                <button type="submit" data-toggle="modal" class="btn" href="#modal_devolve_cam"><span class="">Devolver máquina</span></button>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="modal_devolve_fotos" class="modal hide fade">
            <form name="devolve_fotos" method="POST" action="devolve_fotos">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3>Devolução de fotos</h3>
                </div>
                <div class="modal-body">
                    <p>Arrasta as fotos para o campo abaixo, serão entregues ao dono</p>
                    <input type="text" placeholder="Arrasta as fotos para aqui" name="fotos" id="marca"></input>
                </div>
                <div class="modal-footer">
                    <a data-dismiss="modal" class="btn">Cancelar</a>
                    <button type="submit" class="btn btn-primary" onclick="return valida()">Registar</button>
                </div>
            </form>
        </div>
        <div id="modal_devolve_cam" class="modal hide fade">
            <form name="devolve_vam" method="POST" action="devolve_cam">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3>Devolução de câmara</h3>
                </div>
                <div class="modal-body">
                    <p>Deixa o teu contacto, será enviado para o dono da máquina fotográfica</p>
                    <input type="text" placeholder="Email" name="mail" id="mail"></input>
                </div>
                <div class="modal-footer">
                    <a data-dismiss="modal" class="btn">Cancelar</a>
                    <button type="submit" class="btn btn-primary" onclick="return valida()">Registar</button>
                </div>
            </form>
        </div>
    </body>
</html>
