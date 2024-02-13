<%@page import="Entidad.Cliente"%>
<%
Cliente cli = (Cliente) request.getSession().getAttribute("ClienteSesion");
%>

<h1>Edita tus datos</h1>
<form action="Controller?opID=EditarPerfil" method="POST">
  Nick:
  <input id type="text" name="Nick" size="80"
    placeholder="Introduce tu nuevo nick. Antes era <%=cli.getNick()%>"
  >
  <br>
  Password:
  <input id type="text" name="Password" size="80"
    placeholder="Introduce tu nuevo password. Antes era <%=cli.getPassword()%>"
  >
  <br>
  Nombre:
  <input id type="text" name="Nombre" size="80"
    placeholder="Introduce tu nuevo nombre. Antes era <%=cli.getNombre()%>"
  >
  <br>
  Apellido 1:
  <input id type="text" name="Apellido1" size="80"
    placeholder="Introduce tu nuevo apellido 1. Antes era <%=cli.getApellido1()%>"
  >
  <br>
  Apellido 2:
  <input id type="text" name="Apellido2" size="80"
    placeholder="Introduce tu nuevo apellido 2. Antes era <%=cli.getApellido2()%>"
  >
  <br>
  <input type="submit" value="Entrar">
</form>
