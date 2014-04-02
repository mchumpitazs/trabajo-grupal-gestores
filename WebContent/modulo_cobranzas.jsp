<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  	<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
 
  	<link rel="stylesheet" href="/resources/demos/style.css" />
 
  	<style>
	    .datepicker{
         }
  	</style>
 
  	<script>
  		$(function()  {
		    $( ".datepicker" ).datepicker({
		    	dateFormat: "yy-mm-dd",
		        firstDay: 1,
		        dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
		        dayNamesShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
		        monthNames: 
		            ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
		            "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
		        monthNamesShort: 
		            ["Ene", "Feb", "Mar", "Abr", "May", "Jun",
		            "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"]
		    });
		    }); 	
 	</script>
    
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>SGI: Gestión de Innovación</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-3.1.1.css" rel="stylesheet" media="screen">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
        
	 <div class="container"> 

		<p><strong>Modulo de cobranza</strong></p>
		
		<form id="form1" name="form1" method="post" action="GestionCobranzaServlet" class="form-horizontal" role="form">
			<p>
				<label>
		    		Nombre <input type="text" name="txtnombre"/>
		    	</label>
				<label>	Tipo:
		  			<select class="form-control" name="optipo">
		  				<option>Todos</option>
  						<option>Universidad</option>
  						<option>Instituto</option> 						
  					</select>
  				</label>
  			</p>
  			<p>
  				<label> Mes:
		  			<select class="form-control" name="opmes" >
		  				<option>Todos</option>
  						<option>Enero</option>
  						<option>Febrero</option>
  						<option>Marzo</option>
  						<option>Abril</option>
  						<option>Mayo</option>
  						<option>Junio</option>
  						<option>Julio</option>
  						<option>Agosto</option>
  						<option>Setiembre</option>
  						<option>Octubre</option>
  						<option>Noviembre</option>
  						<option>Diciembre</option>
  					</select>
  				</label>
  				<label> Año:
		  			<select class="form-control" name="opanio" >
  						<option>2009</option>
  						<option>2010</option>
  						<option>2011</option>
  						<option>2012</option>
  						<option>2013</option>
  						<option>2014</option>
  						<option>2015</option>
  						<option>2016</option>
  					</select>
  				</label>
  				<label>	  
		    		<input type="submit" name="button" id="button" value="Buscar" />   
		    	</label>
  			</p>
  		</form>
		<div class="table-responsive">
		<table width="1100" height="20" border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		  <tr>
		    <th width="350" scope="col">Nombre</th>
		    <th width="150" scope="col">Tipo</th>
		    <th width="150" scope="col">Plan Tarifario</th>
		    <th width="90" scope="col">Mes de Pago</th>
		    <th width="70" scope="col">Año</th>
		    <th width="120" scope="col">Monto Mensual(S/.)</th>
		  </tr>
		
		<%@page import="java.util.*, gestores.modelo.ReportePago" %>
		<%
		Collection<Idea> arreglo = (ArrayList<Idea>)request.getAttribute("listax");
		if(arreglo != null) { 
		int i = 1;
		for(Idea x : arreglo) {
		%>  
		  <tr>
		    <%-- <td><%=i++ %></td> --%>
		    <td><% out.print(x.getTitulo()); %></td>
		    <td><% out.print(x.getDescripcion()); %></td>
		    <td><% out.print(x.getPalabrasClave()); %></td>
		    <td><% out.print(x.getArchivo()); %></td>
		    <td><% out.print(x.getEstudiante().getNombre() + " " + x.getEstudiante().getApellidoPaterno() + " " +x.getEstudiante().getApellidoMaterno()); %></td>
		    <td><% out.print(x.getAsesor().getNombre() + " " + x.getAsesor().getApellidoPaterno() + " " +x.getAsesor().getApellidoMaterno()); %></td>
		    <td><% out.print(x.getEstadoIdea().toString()); %></td>
		    <td><% out.print(x.getFechaCreacion()); %></td>
		    
		   </tr>
		<% }  
		  } %>
		  
		</table>
		</div>

 		<!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy; by Marco Chumpitaz </p>
	   </div>
	   
	 </div> <!-- /container -->
    
   


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.1.1.js"></script>
  </body>
</html>
