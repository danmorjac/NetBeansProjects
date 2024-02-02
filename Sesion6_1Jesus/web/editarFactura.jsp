<%@page import="Entidad.Articulo"%>
<%@page import="java.util.List"%>
<jsp:useBean id="ClienteSesion" scope="session" class="Entidad.Cliente" />
<jsp:useBean id="FacturaCliente" scope="request" class="Entidad.Factura" />
<br>IdFactura:<jsp:getProperty name="FacturaCliente" property="id" /> </br>
Fecha: <jsp:getProperty name="FacturaCliente" property="fecha"/> <br>
<form name ="form" action="Controller?opID=EditaFactura" method="POST">
<input type="hidden" name="idFactura" value="<jsp:getProperty name="FacturaCliente" property="id" />" />
Añadir articulo
<select name="productoElegido">
      <%
      List  listadoArticulos=(List) request.getAttribute("listadoArticulos");
      //Creamos una variable auxiliar copia de "listadoArticulos" de la que extraeremos los valores a mostrar
      List  listadoArticulosImprimibles = listadoArticulos;
      //Si el listado contiene valores...
      if (listadoArticulos!=null) {
        //...recorremos los valores...
        for (int i=0;i<listadoArticulosImprimibles.size();i++) { 
          //...y guardamos el artículo actual en "articuloExistente"
          Articulo articuloExistente=(Articulo) listadoArticulosImprimibles.get(i);
          //...creamos una lista "listadoArticulosExcluir" que contiene los artículos que ya están en la factura y que excluiremos de la lista "listadoArticulosImprimibles"
          List  listadoArticulosExcluir=(List) FacturaCliente.getArticulos();
          //...si el listado "listadoArticulosExcluir" contiene valores...
          if (listadoArticulosExcluir!=null) {
            //...recorremos los valores...
            for(int j=0;j<listadoArticulosExcluir.size();j++) {
              //...y guardamos el artículo actual en "articuloExcluir"
              Articulo articuloExcluir =(Articulo) listadoArticulosExcluir.get(j);
              //...comprobamos que el artículo del bucle anterior "articuloExistente" no se encuentra en el valor del bucle actual "articuloExcluir"...
              if(articuloExistente.getId() == articuloExcluir.getId()) {
                //...si se encuentra, se elimina de la lista que mostraremos en el desplegable.
                listadoArticulosImprimibles.remove(i);
                i--;
              }
            }
          }
        }
      
      
      //Ahora, en base a "listadoArticulosImprimibles", grabaremos en el HTML los "options" que no están en la factura.
      //Para cada artículo de la lista de los imprimibles "listadoArticulosImprimibles"...
      for (int i=0;i<listadoArticulosImprimibles.size();i++) { 
        //...guardamos el actual en _articulo.
        Articulo _articulo=(Articulo) listadoArticulosImprimibles.get(i);
        //...y escribimos el option que le corresponde, guardando como value el id y como contenido (descripción - precio) 
        %>
        <option 
           value="<%=_articulo.getId()%>"> <%=_articulo.getDescripcion()%> - <%=_articulo.getPrecio()%> Euros
        </option>
        <%      
        }
      }
      %>
</select>
Cantidad:<input type="text" name="cantidad" value="" />
<input type="submit" value="Añadir" />
<br>Saldo disponible: <jsp:getProperty name="ClienteSesion" property="saldo" /> Euros 
<br>
<% 
  List  listadoArticulosComprados=(List) FacturaCliente.getArticulos();
  if ((listadoArticulosComprados!=null)&&(listadoArticulosComprados.size()>0)) {
  //si queremos que salga un título en la columna de borrar incluimos otro <th> después de <th>Cantidad</th>
  %>
    <table border=1 width="70%">
      <tr>
        <th width="80%">Descripcion</th>
        <th>Cantidad</th>
      </tr>
      <%//recorremos el listado de articulos comprados...
      for (int i=0;i<listadoArticulosComprados.size();i++) {
        //...y guardamos el actual en "_articulo"
        //...luego imprimimos
        Articulo _articulo=(Articulo) listadoArticulosComprados.get(i);%>
        <tr>
          <td><%=_articulo.getDescripcion()%></td>
          <td><%=_articulo.getCantidadComprada()%></td>  
          <td>
            <a href="Controller?opID=BorrarLineaFactura&&idFactura=<jsp:getProperty name="FacturaCliente" property="id"/>&&borraArticulo=<%=_articulo.getId()%>&&cantidad=<%=_articulo.getCantidadComprada()%>">
              Borrar
            </a>
          </td>
        </tr>
      <% } %>                
    </table>
  <%}%>
</form>