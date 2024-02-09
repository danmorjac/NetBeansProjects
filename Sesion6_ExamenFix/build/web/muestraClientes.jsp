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
      <%@page import="Presentation.Utilidad.GetterUtil"%>
            Nick:<input type="text" name="nick" value="<%=GetterUtil.getInstance().getValue(request,"nombre")%>" />
            <br>
    <input type="submit" value="Ver datos" />
       
    </form> 
    </body>
</html>