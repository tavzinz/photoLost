<!DOCTYPE html>
<html>
    <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta charset="utf-8">
            <title>PhotoLost - Recupera as tuas fotos</title>
            <!-- CSS -->
            <link href="libraries/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
            <link href="myStyle.css" rel="stylesheet" media="screen">
            <!-- javascript -->
            <script src="http://code.jquery.com/jquery.js"></script>
            <script src="libraries/bootstrap/js/bootstrap.min.js"></script>
            <script src="myScript.js"></script>
    </head>
    <body>
        <div class="navbar transparent">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li><a role="button" data-toggle="modal" class="navbar-text brand" href="#modal_lost">Perdi a minha m�quina fotogr�fica</a></li>
                        <li class="navbar-text brand">|</li>
                        <li><a role="button" data-toggle="modal" class="navbar-text brand">Encontrei uma m�quina fotogr�fica</a></li>
                        <form class="navbar-form brand" method="POST" action="search_serial">
                                <input type="text" class="span4" name="serial" placeholder="N�mero de s�rie">
                                <button type="submit" class="btn"><span class="">Procurar m�quina</span></button>
                        </form>
                        <li class="navbar-text brand">|</li>
                        <li><a role="button" data-toggle="modal" class="navbar-text brand" href="#modal-help">Ajuda</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="modal_lost" class="modal hide fade">
            <form name="perdida" method="POST" action="search_serial">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3>Registo de c�mara</h3>
                </div>
                <div class="modal-body">
                    <p>Preenche os campos, servir�o para te contactar no caso da tua m�quina ter sido encontrada.</p>
                    <input type="text" placeholder="Marca da m�quina fotogr�fica" name="marca" id="marca"></input></br>
                    <input type="text" placeholder="Modelo da m�quina fotogr�fica" name="modelo" id="modelo"></input></br>
                    <input type="text" placeholder="N�mero de s�rie" name="serial" id="serial"></input></br>
                    <input type="text" placeholder="Endere�o de e-mail de contacto" name="mail" id="mail"></input></br>
                    <input type="text" placeholder="Pasta dropbox para onde enviar as fotos" name="pasta" id="pasta"></input>
                    <input type="text" placeholder="Valor da recompensa" name="recompensa" id="recompensa"></input>
                </div>
                <div class="modal-footer">
                    <a data-dismiss="modal" class="btn">Cancelar</a>
                    <button type="submit" class="btn btn-primary" onclick="return valida()">Registar</button>
                </div>
            </form>
        </div>
        <div id="modal-help" class="modal hide fade">
            <h2>Perdeste a tua m�quina fotogr�fica?</h2>
            <p>Se perdeste a tua m�quina, tens aqui uma hip�tese de recuperar as tuas fotos e at� mesmo a m�quina.</p>
            <p>Muitas vezes mais importante que a m�quina, s�o as fotos que tiraste naquela viagem ou naquele momento especial. Aqui tens uma hip�tese de as recuperar.</p>
            <p>Se algu�m a encontrou, pode-te enviar as fotos de forma an�nima.</p>
            <h2>Encontraste uma m�quina fotogr�fica?</h2>
            <p>Devolve as fotos ao dono, s�o o mais importante, a m�quina, se quiseres, pode ficar para ti.</p>
            <p>� claro que podias fazer a tua boa ac��o e devolver tamb�m a m�quina, de certeza que farias algu�m feliz.</p>
            <p>Se mesmo assim quiseres ficar com a m�quina, envia as fotos, n�o recolhemos nenhum dado teu, � 100% an�nimo.</p>
        </div>
    </body>
</html>