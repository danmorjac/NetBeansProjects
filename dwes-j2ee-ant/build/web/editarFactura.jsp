<%@page import="Entidad.Articulo"%>
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="FacturaCliente" scope="request" class="Entidad.Factura"/>

<h2>Añadir articulos</h2>
<p>idFactura: <jsp:getProperty name="FacturaCliente" property="id"/></p>
<p>Fecha: <jsp:getProperty name="FacturaCliente" property="fecha"/></p>
<form name="form" action="Controller?opID=EditaFactura" method="POST">
  <input 
    type="hidden" 
    name="idFactura" 
    value="<jsp:getProperty name="FacturaCliente" property="id"/>"
    />
  Añadir articulo
  <select name="productoElegido">
    <%
      ArrayList<Articulo> listadoArticulos
        = (ArrayList) request.getAttribute("listadoArticulos");

      ArrayList<Articulo> articulosYaPedidos = FacturaCliente.getArticulos();

      if (listadoArticulos != null && listadoArticulos.size() > 0) {
        for (Articulo artBBDD : listadoArticulos) {
          boolean pedido = false;
          
          if (articulosYaPedidos != null && articulosYaPedidos.size() > 0) {
            for (Articulo artPedido : articulosYaPedidos) {
              if (artBBDD.getId() == artPedido.getId()) {
                pedido = true;
                break;
              }
            }
          }
          
          if (!pedido) {
            %>
              <option value="<%=artBBDD.getId()%>"> 
                <%=artBBDD.getDescripcion()%> - <%=artBBDD.getPrecio()%> Euros
              </option>
            <%
          }
        }
      }
    %>
  </select>
  Cantidad: <input type="text" name="cantidad" value=""/>
  <input type="submit" value="Añadir"/>
  <br>
  <p>
    Saldo disponible: <jsp:getProperty name="ClienteSesion" property="saldo"/>
    Euros
  </p>
  <br>
  <%
    if (articulosYaPedidos != null && articulosYaPedidos.size() > 0) {
      %>
      <table border="1" width="70%">
        <tr>
          <th width="80%">Descripcion</th>
          <th>Cantidad</th>
          <th>Precio unitario</th>
          <th>Precio total</th>
        </tr>
        <%
          for (Articulo art : articulosYaPedidos) {
            %>
        <tr>
          <td><%=art.getDescripcion()%></td>
          <td><%=art.getCantidadComprada()%></td>
          <td><%=art.getPrecio()%></td>
          <td><%=art.getCantidadComprada() * art.getPrecio()%></td>
          <td>
            <a href="Controller?opID=BorrarLineaFactura&&idFactura=<jsp:getProperty name="FacturaCliente" property="id"/>&&productoElegido=<%=art.getId()%>&&cantidad=<%=art.getCantidadComprada()%>">
              Borrar
            </a>
          </td>
        </tr>    
            <%
          }
        %>
      </table>
      <%
    }
  %>
</form>