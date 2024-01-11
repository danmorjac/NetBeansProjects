<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body  bgcolor="#ffffce">
        <%@ include file="navbar.html" %>
        <TABLE border=1 ALIGN="center">
            <TR>
        <% for(int i=0;i<60;i++){
            out.print("<TD>"+i+"</TD>");
            if ((i+1)%6==0)
                out.print("</TR><TR>");
            }
         %>
            </TR>
        </TABLE>
    </body>
</html>
