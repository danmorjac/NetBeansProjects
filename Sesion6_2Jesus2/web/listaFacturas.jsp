<%-- 
    Document   : listafacturas
    Created on : 6 feb. 2024, 15:24:52
    Author     : lliurex
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Factura"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Articulo"%>
<jsp:useBean id="ClienteSesion" scope="session" class="Entidad.Cliente" />
<jsp:useBean id="FacturaCliente" scope="request" class="Entidad.Factura" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Listado de facturas </h1>
           
            <% 
                ArrayList<Factura> facturas = (ArrayList<Factura>) request.getAttribute("facturas");
                
                if(facturas.size() > 0) {
            %>
            <table border="1">
                <tr>
                    <th>Id de factura</th>
                    <th>DNI del cliente</th>
                </tr>
            <%
                    for (Factura factura : facturas) {
                        out.println("<tr>");
                            out.println("<td>" + factura.getId() + "</h3>");
                            out.println("<td>" + factura.getFecha()+ "</td>");
                            out.println("<td><a href='Controller?opID=EditaFactura&idFactura="+ factura.getId() +"'> Editar factura </a></td>");
                            out.println("<td><a href='Controller?opID=BorrarFactura&idFactura="+ factura.getId() +"'> Borrar factura </a></td>");
                        out.println("</tr>");
                    }   
                }else {
                    out.println("<h3>Lo sentimos, no tiene ninguna factura</h3>");
                }
                
            %>
            </tr>
        </table>
    </body>
</html>
