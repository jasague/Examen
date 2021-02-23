<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Visualizar saldo</title>
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
  					<a class="active" href="#">Visualizar el saldo</a>
  					<a href="gestionarUnCDT.jsp">Gestión CDT</a>
				</nav>
			</article>	
			<article>
				<h3>Visualizar el saldo</h3>
				<!-- <form action="svisualizarsaldos" method="POST">
					<table>
						<tr>
							<td>Sacar el saldo de la cuenta</td><td><input type="radio" id="sC" name="accion" value="saldoCuenta"> </td>
						</tr>
						<tr>
							<td>Sacar el saldo del CDT</td><td><input type="radio" id="sCt" name="accion" value="saldoCDT"> </td>
						</tr>
						<tr>
							<td>Sacar el saldo del cliente:</td><td><input type="radio" id="sCi" name="accion" value="saldoCliente"> </td>
						</tr>
						<tr>
							<td>Introduce el identificador::</td><td><input type="text" id="datos" name="datos"> </td>
						</tr>
						<tr>
							<td><input type="submit" value="Consultar Saldo"></td>
						</tr>
					</table>
				</form>	-->
				<div class="centro">
	 				<div class="uno">
		 				<form action="svisualizarsaldos" method="POST">
							 <label for="sC">Sacar el saldo de la cuenta</label>
							<input type="radio" id="sC" name="accion" value="saldoCuenta"> 
							 <label for="sCt">Sacar el saldo del CDT</label>
							<input type="radio" id="sCt" name="accion" value="saldoCDT"> 
							 <label for="sCi">Sacar el saldo del cliente</label>
							<input type="radio" id="sCi" name="accion" value="saldoCliente"> 
							<label for="datos">Introduce el identificador:</label>
							<input type="text" id="datos" name="datos">
							<input type="submit" value="Consultar Saldo">
						</form>
						<%if(request.getAttribute("jspresultado")!=null) {%>
							<span class="resultado">
								Saldo: <%=request.getAttribute("jspresultado") %>
							</span>
						<%}%>
							
							<%if(request.getAttribute("jsperror")!= null){%>
								<div class="error">
								    <%= request.getAttribute("jsperror")%>
								 </div>
							<%} %>
					</div>
				</div>	
			</article>	
		</main>
	</body>
</html>