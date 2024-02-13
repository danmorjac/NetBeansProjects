<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Borrar articulo</h2>
<form action="Controller?opID=BorrarArticulo" method="POST">
  <h3>Atencion! Borrar un articulo puede afectar a las facturas que contengan el articulo</h3>
  <p>Es mejor que primero se borren las facturas relacionadas</p>
  <a href="Controller?opID=ListaFacturas">Ver Facturas</a>
  <p>¿Seguro que deseas eliminar el articulo definitivamente, independientemente de las consequencias?</p>
  <input type="submit" value="Borrar">
</form>
