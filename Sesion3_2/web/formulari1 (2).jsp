<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="myBean" scope="request" class="Entitats.LLoguerBean" />
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    </head>
    <body>
        <%@ include file="navbar.html" %>
        <% if (request.getParameter("envio")==null) { %>
        <form name="exercici2" action="formulari1.jsp" method="POST">
            
            <table bgcolor="#ffffce" border="0" width="100%" cellspacing="1" cellpadding="1">
                <tbody>
                    <tr colspan="4" bgcolor="#ffcf31">
                        <td colspan="4"> <B>VIDEOCLUB ON-LINE</B></TD>
                    </tr>
                    <tr>
                        <td width="20%" bgcolor="#9c9a00"><B>Nom Pel.lícula</B></td>
                        <td><input type="text" name="nom" value="" size="20" /></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td width="20%" bgcolor="#9c9a00"><B>Díes LLoguer</B></td>
                        <td><input type="text" name="dies" value="" size="20" /></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td width="20%" bgcolor="#9c9a00"><B>Edat Client</B></td>
                        <td width="20%" bgcolor="#9c9a00"><B>Forma de pagament</B></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="radio" name="edat" value="-7" >Menor de 7 anys</input><BR>
                            <input type="radio" name="edat" value="-14" >Menor de 14 anys</input><BR>
                            <input type="radio" name="edat" value="-18" >Menor de 18 anys</input><BR>
                            <input type="radio" name="edat" value="+18" >Major de 18 anys</input>
                        </td>
                        <td>
                            <select name="pagament">
                                <option>VISA</option>
                                <option>Xec</option>
                                <option>Comtat</option>
                                <option>Metàlic</option>
                            </select>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td bgcolor="#9c9a00" colspan="2"><B>Especificacions Extra</B></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="3">
                            <textarea name="especificacions" rows="4" cols="80">
                            </textarea>
                        </td>
                        
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="3" align="center">
                            <input type="submit" value="Enviar Comanda" name="envio" />
                            <input type="reset" value="Esborrar Formulari" name="borrar" />
                        </td>
                        
                    </tr>
                </tbody>
            </table>
        </form>
        <% } else { %>
        <% String nom, dies, edat, pagament, especificacions; 
            
        %> 
                <%
                nom = request.getParameter("nom");
                dies =request.getParameter("dies");
                edat = request.getParameter("edat");
                pagament = request.getParameter("pagament");
                especificacions = request.getParameter("especificacions");
                %>
                <jsp:setProperty name="myBean" property="nom" value="<%=nom%>" />                
                <jsp:setProperty name="myBean" property="dies" value="<%=dies%>" />
                <jsp:setProperty name="myBean" property="edat" value="<%=edat%>" />
                <jsp:setProperty name="myBean" property="pagament" value="<%=pagament%>" />
                <jsp:setProperty name="myBean" property="especificacions" value="<%=especificacions%>" />              
                <jsp:forward page="/formulari2.jsp" ></jsp:forward>    --%>      
        
        
        <% }  %>
    </body>
</html>
