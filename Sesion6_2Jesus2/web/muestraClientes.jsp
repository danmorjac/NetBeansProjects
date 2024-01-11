<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Cliente"%>
<%@page import="Presentation.Utilidad.GetterUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form action="Controller?opID=MostrarDetallesCliente" method="POST">
      <h2>Ver datos de cliente</h2>
      <select name="clienteElegido">
      <%
      List  _listadoCliente=(List) request.getAttribute("listadoClientes");
      if (_listadoCliente!=null)
      {
        for (int i=0;i<_listadoCliente.size();i++)
        {
        Cliente _cliente=(Cliente) _listadoCliente.get(i);
        %>
        <option 
          <%if (_cliente.getDNI()==GetterUtil.getInstance().getValueInt(request,"clienteElegido")){%> selected <%}%>
          value="<%=_cliente.getDNI()%>">
          <%=_cliente.getNombre()%> <%=_cliente.getApellido1()%> <%=_cliente.getApellido2()%>
        </option>
        <%      
        }
      }
      %>
      </select> <input type="submit" value="Ver datos" />
    </form>
    </body>
</html>
