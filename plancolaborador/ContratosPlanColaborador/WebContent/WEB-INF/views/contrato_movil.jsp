<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contrato Plan Colaborador M&oacute;vil</title>
<link rel="stylesheet" href="/ContratosPlanColaborador/styles/tigo.css" />
<link rel="stylesheet"
	href="/ContratosPlanColaborador/js/jquery-ui-1.12.1.custom/jquery-ui.css">
<script src="/ContratosPlanColaborador/js/jquery-3.2.1.min.js"></script>
<script src="/ContratosPlanColaborador/js/documentReady.js"></script>
<script
	src="/ContratosPlanColaborador/js/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script>
	function descargarContato() {
		alert("prueba");
	}
</script>
<style type="text/css">
.ui-datepicker {
	font-size: 11px;
}
</style>
</head>
<body>
	<div class="header">
		<img src="/ContratosPlanColaborador/images/FormResource.gif"
			alt="logo" width="92" height="80" class="headerImage"><span
			class="headerTitle">Formulario Contrato Plan Colaborador
			M&oacute;vil</span>
	</div>
	<div class="form-container">
		<form id="formaprincipal">
			<div style="width: 320px; position: absolute; top: 10px; left: 5px;">
				<label for="fechacontrato">Fecha:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="text" id="fechacontrato" class="datepicker" tabindex=1
					value="<%=new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())%>"
					style="width: 177px;" disabled></input>
			</div>
			<div
				style="width: 320px; position: absolute; top: 101px; left: 668px;">
				<label for="cantidadlineas">Cantidad
					Lineas:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label> <input
					type="text" id="cantidadlineas" style="width: 177px;" tabindex=2
					value="1" disabled></input>
			</div>
			<div
				style="width: 350px; position: absolute; top: 56px; left: 668px;">
				<label for="planseleccionado">Plan
					Seleccionado:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label> <input
					type="text" id="planseleccionado" style="width: 175px;" tabindex=3
					<%if (request.getParameter("plan") != null) {
				out.println("value='" + request.getParameter("plan") + "'");
			} else {
				out.println("value=''");
			}%>
					disabled></input>
			</div>
			<div style="width: 670px; position: absolute; top: 56px; left: 5px;">
				<label for="modelotelefono">Modelo
					Tel.:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label> <input type="text"
					id="modelotelefono" style="width: 540px;" tabindex=4
					<%if (request.getParameter("modelo") != null) {
				out.println("value='" + request.getParameter("modelo") + "'");
			} else {
				out.println("value=''");
			}%>
					disabled></input>
			</div>
			<div style="width: 670px; position: absolute; top: 101px; left: 5px;">
				<label for="observaciones">Observaciones:&nbsp; </label> <input
					type="text" id="observaciones" style="width: 540px;" tabindex=5></input>
			</div>

			<div
				style="width: 300px; position: absolute; top: 150px; left: 5px; background-color: #444d9a; color: white; font-size: 18px; font-weight: bold; padding-left: 20px; border-radius: 25px;">
				<span>Datos Personales</span>

			</div>

			<div style="width: 670px; position: absolute; top: 199px; left: 5px;">
				<label for="nombre">Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="text" id="nombre" style="width: 540px;" tabindex=6
					<%if (request.getParameter("nombre") != null) {
				out.println("value='" + request.getParameter("nombre") + "'");
			} else {
				out.println("value=''");
			}%>
					disabled></input>
			</div>
			<div
				style="width: 400px; position: absolute; top: 199px; left: 668px;">
				<label for="fechanacimiento">Fecha de Nacimiento:&nbsp; </label> <input
					type="text" id="fechanacimimento" class="datepicker" tabindex=7
					style="width: 173px;"></input>
			</div>
			<div
				style="width: 1000px; position: absolute; top: 243px; left: 5px;">
				<label for="direccion">Direcci&oacute;n:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="text" id="direccion" style="width: 874px;" tabindex=8
					<%if (request.getParameter("direccion") != null) {
				out.println("value='" + request.getParameter("direccion") + "'");
			} else {
				out.println("value=''");
			}%>
					disabled></input>
			</div>
			<div style="width: 300px; position: absolute; top: 287px; left: 5px;">
				<label for="dpi">DPI:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="text" id="dpi" style="width: 177px;" tabindex=8
					<%if (request.getParameter("dpi") != null) {
				out.println("value='" + request.getParameter("dpi") + "'");
			} else {
				out.println("value=''");
			}%>
					disabled></input>
			</div>
			<div
				style="width: 300px; position: absolute; top: 287px; left: 310px;">
				<label for="nit">NIT:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="text" id="nit" style="width: 177px;" tabindex=8
					<%if (request.getParameter("nit") != null) {
				out.println("value='" + request.getParameter("nit") + "'");
			} else {
				out.println("value=''");
			}%>
					disabled></input>
			</div>
			<div
				style="width: 500px; position: absolute; top: 287px; left: 575px;">
				<label for="email">E-Mail:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <input type="text" id="email" style="width: 333px;" tabindex=8
					<%if (request.getParameter("email") != null) {
				out.println("value='" + request.getParameter("email") + "'");
			} else {
				out.println("value=''");
			}%>
					disabled></input>
			</div>
			<div style="width: 450px; position: absolute; top: 332px; left: 5px;">
				<label for="telefono">Tel. Contacto:&nbsp;&nbsp;&nbsp; </label> <input
					type="text" id="telefono" style="width: 177px;" tabindex=8></input>
			</div>
			<div
				style="width: 1000px; position: absolute; top: 400px; text-align: center">
				<button onclick="descargarContato()">Descargar Contrato</button>
			</div>


		</form>
	</div>
</body>
</html>