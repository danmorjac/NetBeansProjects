
<%@page import="java.util.List"%>
<%@page import="Entidad.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="Controller?opID=Ejercicio2" method="POST">
      <h2>Listado de clientes</h2>
     
      <%
       List<Cliente>  _clientes=(List<Cliente>) request.getAttribute("ListadoClientes");
       
      if (_clientes!=null)
          
      {
          //List _listado = (List) _cliente.getFacturas();
        %>
          <table border=1 width="60%">
      <tr>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Apellido1</th>
        <th>Apellido2</th>
        <th>Nick</th>
        <th>Passwd</th>
        <th>Moroso</th>
        <th>Saldo</th>
      </tr>
      <%
          
          
      for (int i=0;i<_clientes.size();i++) {
              Cliente _cliente=(Cliente) _clientes.get(i); %>
        <tr>
            <td><%=_cliente.getDNI()%></td>
          <td><%=_cliente.getNombre()%></td>
          <td><%=_cliente.getApellido1()%></td> 
          <td><%=_cliente.getApellido2()%></td> 
          <td><%=_cliente.getNick()%></td> 
          <td><%=_cliente.getPassword()%></td>
          <td><%=_cliente.isMoroso()%></td>
          <td><%=_cliente.getSaldo()%></td>
          <td>
         <a href="Controller?opID=PedirCliente&&dniCliente=<%=_cliente.getDNI()%>">
              Editar
            </a>
          </td>
          <td>
         <a href="Controller?opID=BorrarUsuario&&nickCliente=<%=_cliente.getNick()%>">
              Borrar
            </a>
          </td>

        </tr>
      <% }
      
      }%>                
    </table>
    </form>
    </body>
</html>
