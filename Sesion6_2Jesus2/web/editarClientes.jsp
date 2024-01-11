<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Presentation.Utilidad.GetterUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar clientes</title>
    </head>
    <body>
      <h2>Editar/Borrar Clientes</h2>
      <table border='1' rules='all' cellpadding="10">
          <tr>
              <th>Cliente</th>
              <th colspan="2">Opciones</th>
          </tr>
      
      <%
      List  _listadoCliente=(List) request.getAttribute("listadoClientes");
      if (_listadoCliente!=null) {
        for (int i=0;i<_listadoCliente.size();i++) {
            Cliente _cliente=(Cliente) _listadoCliente.get(i);
            %>
            <tr>
                <td>
                    <%=_cliente.getNombre()%> <%=_cliente.getApellido1()%> <%=_cliente.getApellido2()%>
                </td>
                <td>
                    <a href="Controller?opID=EditarCliente&&clienteElegido=<%=_cliente.getDNI()%>">Editar</a>
                </td>
                <td>
                    <a href="Controller?opID=BorrarCliente&&clienteElegido=<%=_cliente.getDNI()%>">Borrar</a>
                </td>
            </tr>
            <%      
        }
      }
      %>
      </table>
    </body>
</html>