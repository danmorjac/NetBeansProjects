<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="dades" scope="application" class="Entitats.dadesPantallaBean" />
<% String nick = (String)session.getAttribute("nick");%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <H2><%=nick%></H2>
          <form name="exercici4" action="ReplegaDadesXat" method="POST">
            <input type="text" name="text" value="" size="50" />
            <input type="hidden" name="user" value="<%=nick%>"  /><BR>
            <input type="submit" name="envia" value="Enviar" size="20" />
            <input type="submit" name="actualitza" value="Actualitzar" size="20" /><BR>
            <textarea name="datos" rows="10" cols="80" readOnly>
            <jsp:getProperty name="dades" property="text" />
            </textarea>
        </form>
    </body>
</html>
