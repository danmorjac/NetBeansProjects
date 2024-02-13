<%@page import="Entidad.Cliente"%>
<%
Cliente cli = (Cliente) request.getAttribute("Cliente");
%>

<h1>Edita tus datos</h1>
<form action="Controller?opID=EditarCliente" method="POST">
  Nick:
  <input id type="text" name="Nick" size="80"
    value="<%=cli.getNick()%>"
  >
  <br>
  Password:
  <input id type="text" name="Password" size="80"
    value="<%=cli.getPassword()%>"
  >
  <br>
  Nombre:
  <input id type="text" name="Nombre" size="80"
    value="<%=cli.getNombre()%>"
  >
  <br>
  Apellido 1:
  <input id type="text" name="Apellido1" size="80"
    value="<%=cli.getApellido1()%>"
  >
  <br>
  Apellido 2:
  <input id type="text" name="Apellido2" size="80"
    value="<%=cli.getApellido2()%>"
  >
  <input type="number" name="DNI" hidden="true" value="<%=cli.getDNI()%>">
  <br>
  <input type="submit" value="Entrar">
</form>
