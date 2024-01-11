<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Cliente"%>

<%Cliente trySesion=(Cliente) request.getSession().getAttribute("ClienteSesion");
if (trySesion == null)  { %>       
    <a href="Controller?opID=MostrarLogin">Identifiquese</a>
    <br>
    <a href="Controller?opID=MostrarRegistro">Registrese</a>
<%}else{%>
    <a href="Controller?opID=MostrarClientes">Clientes</a>
    <br>
    <a href="Controller?opID=EditaFactura">Comprar</a>
    <br>
    <a href="Controller?opID=Google">Mapa de google</a>
    <br>    
    <a href="Controller?opID=Ejercicio2">Ver Facturas</a>
    <br>
    <a href="Controller?opID=MostrarEditarPerfil">Editar Perfil</a>
    <br>
    <a href="Controller?opID=MostrarBorrarPerfil">Borrar Perfil</a>
    <br>
    <a href="Controller?opID=Ejercicio4">Editar Clientes</a>
    <br>
<% } %>



                        
                         

