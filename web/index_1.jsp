<%-- 
    Document   : index
    Created on : 30/Mai/2013, 18:38:42
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="utf-8">
		<title>PhotoLost - Recupere as suas fotos</title>
		<!-- CSS -->
		<link href="libraries/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<link href="myStyle.css" rel="stylesheet" media="screen">
		<!-- javascript -->
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="libraries/bootstrap/js/bootstrap.min.js"></script>
                <script src="myScript.js"></script>
	</head>
	<body>
            
		<div id ="btns">
			<a role="button" data-toggle="modal" class="btn btn-primary btn-large" href="#modal_lost">Perdi a minha máquina fotográfica</a>
			<a role="button" data-toggle="modal" class="btn btn-primary btn-large" href="#modal_find">Encontrei uma máquina fotográfica</a>
		</div>
		<!-- modal para procura máquina registada na BD-->
		<div id="modal_find" class="modal hide fade">
			<form name="procura" method="POST" action="search_serial">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h3>Procura de câmara</h3>
				</div>
				<div class="modal-body">
					<p>Introduza no campo o número de série da máquina fotográfica que encontrou, iremos procurá-la na nossa base de dados.</p>
					<input type="text" placeholder="Número de série" name="serial"></input>
				</div>
				<div class="modal-footer">
					<a data-dismiss="modal" class="btn">Cancelar</a>
					<button id="search" type="submit" class="btn btn-primary">Procurar</button>
				</div>
			</form>
		</div>
		<!-- modal para registo de máquina perdida-->
		<div id="modal_lost" class="modal hide fade">
			<form name="perdida" method="POST" action="regist_serial">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h3>Registo de câmara</h3>
				</div>
				<div class="modal-body">
					<p>Preencha os campos, servirão para o contactar no caso da sua máquina ter sido encontrada.</p>
					<input type="text" placeholder="Marca da máquina fotográfica" name="marca"></input></br>
					<input type="text" placeholder="Modelo da máquina fotográfica" name="modelo"></input></br>
					<input type="text" placeholder="Número de série" name="serial"></input></br>
					<input type="text" placeholder="Endereço de e-mail de contacto" name="mail"></input></br>
					<input type="text" placeholder="Pasta dropbox para onde enviar as fotos" name="pasta"></input>
				</div>
				<div class="modal-footer">
					<a data-dismiss="modal" class="btn">Cancelar</a>
					<button type="submit" class="btn btn-primary">Registar</button>
				</div>
			</form>
		</div>
                <div id="resposta"></div>
	</body>
</html>