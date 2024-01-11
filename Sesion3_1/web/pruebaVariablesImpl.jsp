<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        La IP de tu ordenador es: <%= request.getRemoteHost() %>
        <BR>
        El nombre del servidor es:<%= request.getServerName() %>
        <BR>
        El puerto del servidor: <%=request.getServerPort() %>
        <BR>
        La IP del servidor es:<%=request.getRemoteAddr() %>
        <BR>
        El protocolo que estas usando es: <%=request.getProtocol() %>        
        </body>
</html>
