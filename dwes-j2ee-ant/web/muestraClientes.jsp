<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Presentation.Utilidad.GetterUtil"%>

<form action="Controller?opID=MostrarDetallesCliente" method="POST">
  <h2>Ver datos de cliente</h2>
  <select name="clienteElegido">
    <%
      ArrayList<Cliente> listadoClientes = 
        (ArrayList<Cliente>) request.getAttribute("listadoClientes");
      
      int dniElegido = GetterUtil.getInstance()
        .getValueInt(request, "clienteElegido");
        
        if (listadoClientes != null) {
          for (int i = 0; i < listadoClientes.size();i++) {
            Cliente cli = (Cliente) listadoClientes.get(i);
    %>
    <option
      <% if (cli.getDNI() == dniElegido) %>selected<%%>
      value="<%=cli.getDNI()%>"
    >
      <%=cli.getNombreCompuesto()%>
    </option>
    <%
        }
      }
    %>
  </select>
  <input type="submit" value="Ver datos"/>
</form>
