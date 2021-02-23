<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestionar un CDT</title>
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
 					<a href="ingresar_retirar.jsp">Ingresar / Retirar</a>
  					<a href="visualizarSaldos.jsp">Visualizar el saldo</a>
  					<a class="active" href="#">Gestión CDT</a>
				</nav>
			</article>
			<article>
				<h3>Gestión CDT</h3>
				<!-- <form action="scdt" method="POST">
					<table>
						<tr>
							<td>Crear un CDT</td><td><input type="radio" id="cCDT" name="accion" value="CrearCDT"> </td>
						</tr>
						<tr>
							<td>Cerrar un CDT</td><td><input type="radio" id="ceCDT" name="accion" value="CerrarCDT"> </td>
						</tr>
						<tr>
							<td>Cuenta: </td><td><input type="text" id="cuenta" name="cuenta"> </td>
						</tr>
						<tr>
							<td>Interes: </td><td><input type="text" id="interes" name="interes"> </td>
						</tr>
						<tr>
							<td>CDT: </td><td><input type="text" id="cdt" name="cdt"> </td>
						</tr>
						<tr>
							<td>Monto: </td><td><input type="text" id="monto" name="monto"> </td>
						</tr>
						<tr>
							<td><input type="submit" value="Realizar la acción"></td>
						</tr>
					</table>
				</form>	-->
				<div class="centro">
					<div class="uno">
						<form action="scdt" method="POST">
							<label for="cCDT">Crear un CDT</label>
							<input type="radio" id="cCDT" name="accion" value="CrearCDT">
							<label for="ceCDT">Cerrar un CDT</label>
							<input type="radio" id="ceCDT" name="accion" value="CerrarCDT">
							<label for="cuenta">Cuenta: </label>
							<input type="text" id="cuenta" name="cuenta">
							<label for="interes">Interes: </label>
							<input type="text" id="interes" name="interes">
							<label for="cdt">CDT: </label>
							<input type="text" id="cdt" name="cdt">
							<label for="monto">Monto: </label>
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