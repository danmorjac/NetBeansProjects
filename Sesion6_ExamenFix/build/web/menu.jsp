<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Cliente"%>

<%Cliente trySesion=(Cliente) request.getSession().getAttribute("ClienteSesion");
if (trySesion == null){ %> 
   <a href="Controller?opID=MostrarCrearCliente">Crear cliente</a><br>
  <br>
  <a href="Controller?opID=MostrarLogin">Identifiquese</a><br>
  <br>
  <a href="Controller?opID=MostrarClientes">Buscar Cliente por Nick</a>

    
    
<%} else {
  if (trySesion.getDNI() == 1) {%>
   <a href="Controller?opID=ListadoClientes">Listado de Clientes </a><br><br> <%}%>
  
    <a href="Controller?opID=MostrarEditarUsuario">Editar Usuario</a><br><br>
    
    <a href="Controller?opID=MostrarBorrarUsuario">Eliminar Usuario</a><br><br>
    
    <a href="Controller?opID=MostrarCrearCliente">Crear cliente</a><br><br>
    
    <a href="Controller?opID=MostrarClientes">Buscar Cliente por Nick</a><br><br>
    
    <a href="Controller?opID=listadoClientes">Mostrar Clientes</a><br><br>
    
    <a href="Controller?opID=EditaFactura">Comprar</a><br><br>
    
    <a href="Controller?opID=MostrarFacturas">Listado de Facturas</a><br><br>
  
  
<%}%>