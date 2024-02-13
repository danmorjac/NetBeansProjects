<%-- 
    Document   : listarArticulos
    Created on : 13 feb 2024, 12:10:39
    Author     : pablo
--%>

<%@page import="Entidad.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2>Articulos disponibles en la tienda</h2>

<%
  ArrayList<Articulo> articulos
          = (ArrayList) request.getAttribute("listadoArticulos");

  boolean isAdmin = (boolean) request.getAttribute("isAdmin");

  if (articulos != null && articulos.size() > 0) {

%>

<table border="1" rules="all" cellpadding="10">
  <tr>
    <th>Id</th>
    <th>Nombre</th>
    <th>Precio</th>
    <th>Stock</th>
    <th colspan="2">Opciones</th>
  </tr>

  <%    for (Articulo art : articulos) {
  %>

  <tr>
    <td><%=art.getId()%></td>
    <td><%=art.getDescripcion()%></td>
    <td><%=art.getPrecio()%></td>
    <td><%=art.getStock()%></td>
    <td>
      <%
        if (isAdmin) {
      %>
      <a href="Controller?opID=MostrarBorrarArticulo&&articuloElegido=<%=art.getId()%>">
        Borrar
      </a>          
      <%
      } else {
      %><p>No puedes borrar</p><%
        }
      %>
    </td>
    <td>
      <%
        if (isAdmin) {
      %>
      <a href="Controller?opID=MostrarEditarArticulo&&articuloElegido=<%=art.getId()%>">
        Editar
      </a>          
      <%
      } else {
      %><p>No puedes Editar</p><%
        }
      %>
    </td>
  </tr>

  <%
    }
  } else {
  %><p>No hay articulos a motrar</p>
  <%
    }
  %>
</table>

<%
  if (isAdmin) {
%>

<br>
<button>
  <a href="Controller?opID=MostrarAddArticulo">
    Añadir Articulo
  </a>
</button>

<%
  }
%>
