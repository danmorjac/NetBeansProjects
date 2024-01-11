<%-- 
    Document   : dameFacturas
    Created on : 10-mar-2014, 16:20:08
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Factura"%>
<%@page import="Presentation.Utilidad.GetterUtil"%>
<%@page import="Entidad.Cliente"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <form action="Controller?opID=Ejercicio2" method="POST">
      <h2>Factura del cliente</h2>
     
      <%
      Cliente  _cliente=(Cliente) request.getAttribute("FacturasCliente");
      if (_cliente!=null) {
          List _listaFacturas = (List) _cliente.getFacturas();
        %>
          <table border=1 width="60%">
      <tr>
        <th width="60%">id</th>
        <th>Fecha</th>
      </tr>
      <%  
      for (int i=0;i<_listaFacturas.size();i++) {
              Factura _factura=(Factura) _listaFacturas.get(i); %>
        <tr>
            <td><%=_factura.getId()%></td>
          <td><%=_factura.getFecha()%></td>  
          <td>
         <a href="Controller?opID=EditaFactura&&idFactura=<%=_factura.getId()%>">
              Editar
            </a>
          </td>

        </tr>
      <% }
      
      }%>                
    </table>     
    </form>
    </body>
</html>
