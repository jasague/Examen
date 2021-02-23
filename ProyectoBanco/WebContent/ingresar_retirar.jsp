<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ingresar-Retirar</title>
		<link rel="stylesheet" type="text/css" href="static/base.css" />
	</head>
	<body>
		<main>
			<article>
				<header>
					<h1>Menú banco</h1>
				</header>
				<nav class="topnav">
					<a href="index.jsp">Inicio</a>
 					<a class="active" href="#">Ingresar / Retirar</a>
  					<a href="visualizarSaldos.jsp">Visualizar el saldo</a>
  					<a href="gestionarUnCDT.jsp">Gestión CDT</a>
				</nav>
			</article>
			<article>
				<h3>Ingresar o retirar</h3>
				 <!-- <form action="sinre" method="POST">
					<table>
						<tr>
							<td>Ingresar</td><td><input type="radio" id="ingresar" name="accion" value="Ingresar"></td>
						</tr>
						<tr>
							<td>Retirar</td><td><input type="radio" id="retirar" name="accion" value="Retirar"></td>
						</tr>
						<tr>
							<td>Cuenta:</td><td><input type="text" id="cuenta" name="cuenta"> </td>
						</tr>
						<tr>
							<td>Monto:</td><td><input type="text" id="monto" name="monto"> </td>
						</tr>
						<tr>
							<td><input type="submit" value="Realizar la acción"></td>
						</tr>
					</table>
				</form>	-->
				<div class="centro">
					<div class="uno">
						<form action="sinre" method="POST">
							 <label for="ingresar">Ingresar</label>
							<input type="radio" id="ingresar" name="accion" value="Ingresar"> 
							 <label for="retirar">Retirar</label>
							<input type="radio" id="retirar" name="accion" value="Retirar"> 
							 <label for="cuenta">Cuenta</label>
							<input type="text" id="cuenta" name="cuenta"> 
							 <label for="monto">Monto</label>
							<input type="text" id="monto" name="monto"> 
							<input type="submit" value="Realizar la acción">
						</form>
							<%if(request.getAttribute("jspresultado")!=null) {%>
								<span>
									<%=request.getAttribute("jspresultado") %>
								</span>
							<%}%>

							<%if(request.getAttribute("jsperror")!=null) {%>
								<div class="error">	
									<%=request.getAttribute("jsperror") %>
								</div>
							<%}%>			
					</div>
				</div>

			</article>
		</main>
	</body>
</html>