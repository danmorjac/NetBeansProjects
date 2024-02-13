<%@page import="Entidad.Articulo"%>
<h2>Edita el articulo</h2>

<%
Articulo art = (Articulo) request.getSession().getAttribute("articuloEditar");
%>

<p>Id del articulo a editar: <%=art.getId()%></p>

<form action="Controller?opID=EditarArticulo" method="POST">
  <input type="text" hidden="true" value="<%=art.getId()%>" name="idArticulo">
  Descripcion:
  <input type="text" name="Descripcion" size="80"
    value="<%=art.getDescripcion()%>"
  >
  <br>
  Precio:
  <input type="number" name="Precio" size="80"
    value="<%=art.getPrecio()%>"
  >
  <br>
  Stock:
  <input type="number" name="Stock" size="80"
    value="<%=art.getStock()%>"
  >
  <br>
  <input type="submit" value="Entrar">
</form>