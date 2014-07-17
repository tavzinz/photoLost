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
                        <li><a role="button" data-toggle="modal" class="navbar-text brand" href="#modal_lost">Perdi a minha máquina fotográfica</a></li>
                        <li class="navbar-text brand">|</li>
                        <li><a role="button" data-toggle="modal" class="navbar-text brand">Encontrei uma máquina fotográfica</a></li>
                        <form class="navbar-form brand" method="POST" action="search_serial">
                                <input type="text" class="span4" name="serial" placeholder="Número de série">
                                <button type="submit" class="btn"><span class="">Procurar máquina</span></button>
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
                    <h3>Registo de câmara</h3>
                </div>
                <div class="modal-body">
                    <p>Preenche os campos, servirão para te contactar no caso da tua máquina ter sido encontrada.</p>
                    <input type="text" placeholder="Marca da máquina fotográfica" name="marca" id="marca"></input></br>
                    <input type="text" placeholder="Modelo da máquina fotográfica" name="modelo" id="modelo"></input></br>
                    <input type="text" placeholder="Número de série" name="serial" id="serial"></input></br>
                    <input type="text" placeholder="Endereço de e-mail de contacto" name="mail" id="mail"></input></br>
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
            <h2>Perdeste a tua máquina fotográfica?</h2>
            <p>Se perdeste a tua máquina, tens aqui uma hipótese de recuperar as tuas fotos e até mesmo a máquina.</p>
            <p>Muitas vezes mais importante que a máquina, são as fotos que tiraste naquela viagem ou naquele momento especial. Aqui tens uma hipótese de as recuperar.</p>
            <p>Se alguém a encontrou, pode-te enviar as fotos de forma anónima.</p>
            <h2>Encontraste uma máquina fotográfica?</h2>
            <p>Devolve as fotos ao dono, são o mais importante, a máquina, se quiseres, pode ficar para ti.</p>
            <p>É claro que podias fazer a tua boa acção e devolver também a máquina, de certeza que farias alguém feliz.</p>
            <p>Se mesmo assim quiseres ficar com a máquina, envia as fotos, não recolhemos nenhum dado teu, é 100% anónimo.</p>
        </div>
    </body>
</html>