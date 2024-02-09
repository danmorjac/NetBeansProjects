<%@page import="Entidad.Cliente"%>
<%@page import="Presentation.Utilidad.GetterUtil"%>

<%
     Cliente _cliente=(Cliente) request.getSession().getAttribute("ClienteSesion");
%>
<h2>Borrado de este usuario</h2>
<form action="Controller?opID=BorrarUsuario&&nickCliente=<%=_cliente.getNick()%>" method="POST">
    Dale al botón si quieres borrar este usuario. </br>
    <input type="submit" value="Borrar usuario" />    
</form>
