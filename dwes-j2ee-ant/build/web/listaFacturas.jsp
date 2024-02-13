<%@page import="BLL.FacturaBLL"%>
<%@page import="Entidad.Factura"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="ClienteSesion" scope="session" class="Entidad.Cliente"/>
<jsp:useBean id="FacturaCliente" scope="request" class="Entidad.Factura"/>
<h2>Listado facturas</h2>
<%
  ArrayList<Factura> listaFactura
    = (ArrayList) request.getAttribute("facturas");

  if (listaFactura.size() > 0) {
%>

<table border="1">
  <tr>
    <th>Id de factura</th>
    <th>Fecha</th>
    <th>Cuantia total</th>
  </tr>
    <%
      for (Factura fct : listaFactura) {
      
        float cuantia = new FacturaBLL().getTotal(fct.getId());
    %>
  <tr>
    <td><%=fct.getId()%></td>
    <td><%=fct.getFecha()%></td>
    <td><%=cuantia%></td>
    <td>
      <a href="Controller?opID=EditaFactura&&idFactura=<%=fct.getId()%>">
        Editar
      </a>
    </td>
    <td>
      <a href="Controller?opID=BorrarFactura&&idFactura=<%=fct.getId()%>">
        Borrar
      </a>
    </td>
  </tr>
    <%
      }
    %>
</table >
<%
} else {
%>
<h3>Lo sentimos, no tiene ninguna factura</h3>
<%
  }
%>
