<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <table height="100%"border=2 width="100%">
        <tr><td align="center" textcolor=white height="5%" bgcolor=blue colspan=2>Aplicacion web</td></tr>
        <tr>
            <td align="center" bgcolor=cyan width="10%">
            <jsp:include page="menu.jsp" />
            </td>
            <td width="75%">
            Sentimos comunicarle que su última operación ha generado un error inseperado,pongase en contacto 
            con el administrador para solucionarlo lo antes posible. Su ticket de localizaciónn de error 
            es <%=request.getAttribute("tickectId")%>. 
            <br>
            Si no es molestia mande un mail al <a href="mailto:administrador@application.com" target="_blank">
            adminitrador</a> indicando su ticket y describiendo la operación que realizaba previa al error.      
            </td></tr>
        <tr><td align="center" color=white height="5%" bgcolor=blue colspan=2>Creado por alumnos</td></tr> 
        </table>
    </body>
</html>
