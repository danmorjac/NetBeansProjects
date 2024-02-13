<%@page import="Entidad.Cliente"%>
<%@page import="java.util.ArrayList"%>

<table border="1" rules="all" cellpadding="10">
  <tr>
    <th>Cliente</th>
    <th colspan="2">Opciones</th>
  </tr>
  <%
    ArrayList<Cliente> listaClientes = 
      (ArrayList) request.getAttribute("listadoClientes");
      
    boolean isAdmin = (boolean) request.getAttribute("isAdmin");

    if (listaClientes != null) {
      for (Cliente cli : listaClientes) {
        %>

  <tr>
    <td><%=cli.getNombreCompuesto()%></td>
    <td>
      <%
        if (isAdmin) {
          %>
      <a href="Controller?opID=MostrarEditarCliente&&clienteElegido=<%=cli.getDNI()%>">
        Editar
      </a>          
          <%
        } else {
          %><p>No puedes editar</p><%
        }
      %>
    </td>
    
    <td>
      <%
        if (isAdmin) {
          %>
      <a href="Controller?opID=MostrarBorrarCliente&&clienteElegido=<%=cli.getDNI()%>">
        Borrar
      </a>          
          <%
        } else {
          %><p>No puedes borrar</p><%
        }
      %>
    </td>
  </tr>
        <%
      }
    }
  %>
</table>

