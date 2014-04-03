<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<div class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextPath}/PortadaServlet">Sistema
				de Gesti�n de Innovaci�n</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${contextPath}/PortadaServlet">Inicio</a></li>
				<c:if
					test="${usuarioActual.estudiante or usuarioActual.administrador}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Mantenimiento</a>
						<ul class="dropdown-menu">
							<c:if test="${usuarioActual.estudiante}">
								<li><a href="#">Ideas</a></li>
							</c:if>
							<c:if test="${usuarioActual.administrador}">
								<li><a href="${contextPath}/InicioCentroFormacionServlet">Centros
										de Formaci�n</a></li>
								<li><a href="#">Usuarios</a></li>
							</c:if>
						</ul></li>
				</c:if>
				<c:if test="${not usuarioActual.administrador}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Gesti�n</a>
						<ul class="dropdown-menu">
							<c:if
								test="${usuarioActual.estudiante or usuarioActual.docente or usuarioActual.evaluador}">
								<li><a href="#">Consulta de Ideas</a></li>
							</c:if>
							<c:if test="${usuarioActual.docente}">
								<li><a href="#">Registro de Reuniones</a></li>
							</c:if>
							<c:if test="${usuarioActual.estudiante}">
								<li><a href="#">Publicaci�n de Ideas</a></li>
							</c:if>
							<c:if test="${usuarioActual.estudiante or usuarioActual.docente}">
								<li><a href="#">Participaci�n de Ideas</a></li>
							</c:if>
							<c:if test="${usuarioActual.evaluador}">
								<li><a href="#">Evaluaci�n de Ideas</a></li>
							</c:if>
						</ul></li>
				</c:if>
				<c:if
					test="${usuarioActual.evaluador or usuarioActual.administrador}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Reporte</a>
						<ul class="dropdown-menu">
							<c:if test="${usuarioActual.evaluador}">
								<li><a href="#">Ideas</a></li>
							</c:if>
							<c:if test="${usuarioActual.administrador}">
								<li><a href="#">Pagos de Centro de Formaci�n</a></li>
							</c:if>
						</ul></li>
				</c:if>
				<li><a href="${contextPath}/LogoutServlet">Salir</a></li>
			</ul>
		</div>
	</div>
</div>