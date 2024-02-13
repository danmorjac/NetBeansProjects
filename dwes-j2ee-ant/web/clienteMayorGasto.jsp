<%@page import="Entidad.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  Cliente cli = 
    (Cliente) request.getSession().getAttribute("ClienteMayorGasto");
%>

<!DOCTYPE html>
<h2>Cliente que ha realizado el mayor gasto</h2>

<table border="1" width="70%">
  <tr>
    <th>Nombre</th>
    <th>Gasto realizado</th>
  </tr>
  <tr>
    <td><%=cli.getNombreCompuesto()%></td>
    <td><%=cli.getSaldo()%></td>
  </tr>
</table>
