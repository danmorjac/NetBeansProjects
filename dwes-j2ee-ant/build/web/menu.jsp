<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Cliente"%>

<%Cliente trySesion = (Cliente) request.getSession().getAttribute("ClienteSesion");
  if (trySesion == null) { %>       
<a href="Controller?opID=MostrarLogin">Identifiquese</a>
<br>
<a href="Controller?opID=MostrarRegistro">Registrese</a>
<%} else {%>
<a href="Controller?opID=MostrarClientes">Clientes</a>
<br>
<a href="Controller?opID=EditaFactura">Comprar</a>
<br>    
<a href="Controller?opID=ListaFacturas">Ver Facturas</a>
<br>
<a href="Controller?opID=MostrarEditarPerfil">Editar Perfil</a>
<br>
<a href="Controller?opID=MostrarBorrarPerfil">Borrar Perfil</a>
<br>
<a href="Controller?opID=MostrarEditarBorrarClientes">Editar Clientes</a>
<br>
<a href="Controller?opID=ClienteMayorGasto">
  Cliente con mayor gasto
</a>
<br>
<a href="Controller?opID=ListarArticulos">
  Ver Articulos
</a>
<% }%>
