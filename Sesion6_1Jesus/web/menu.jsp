<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Cliente"%>

<%Cliente trySesion=(Cliente) request.getSession().getAttribute("ClienteSesion");
if (trySesion == null)  { %>       
  <a href="Controller?opID=MostrarLogin">Identifiquese</a>
  <br>
<%}else{%>
  <a href="Controller?opID=MostrarClientes">Clientes</a>
  <br>
  <a href="Controller?opID=EditaFactura">Comprar</a>
<%}%>



                        
                         

