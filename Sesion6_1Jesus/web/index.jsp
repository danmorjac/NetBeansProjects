<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidad.Cliente"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aplicación JSP</title>
  </head>
  <body>        
    <table height="100%"border=2 width="100%">
      <tr>
        <td  height="5%" bgcolor=blue colspan=2>
          <table width=100%>
            <tr>
              <td style="color:white" align="center" width="75%">Aplicación web</td>
              <td style="color:white" align="right">
                <!-- LEEME -->
                        <!-- Comprueba si la variable sesion esta inicializada   -->
                       <% 
                         if (request.getParameter("sesion") != null) 
                        { 
                            //Si esta iniciada LA BORRA, por que he llegado aqui desde el boton "log out"
                            request.getSession().removeAttribute("ClienteSesion");
                        }else{
                             //Si no esta iniciada pues imprime el nombre del logeado
                             Cliente _clienteSesion=(Cliente) request.getSession().getAttribute("ClienteSesion");
                        if (_clienteSesion != null){%><%=_clienteSesion.getNombreCompuesto()%>
                    </td>     
                    <td>
                        <!-- Comprueba si se ha apretado cogiendo la variable y entonces cierra sesion-->
                        <form action="index.jsp" method="post"> 
                        <input type="Submit" name="sesion" value="Log Out" > 
                        <!-- Envia a si mismo el jsp asi cerrara sesion con el codigo de arriba.-->
                        </form>
                        <%}
                        }%>  
                </tr></table>                                        
            </td>
            </tr>
        <tr>
        <td align="center" bgcolor=cyan width="10%"><jsp:include page="menu.jsp" /></td>
        <td width="75%">    
          <%String _advertencia=(String) request.getAttribute("advertencia");
          if (_advertencia != null){%><label style="color:red"><%=_advertencia%></label> <%}%>                
          <%String paginaprincipal=(String) request.getAttribute("paginaprincipal");
          if (paginaprincipal != null){%> 
          <jsp:include page='<%=(String) request.getAttribute("paginaprincipal")%>' />
          <%}%>                
        </td>
      </tr>
      <tr>
        <td align="center" style="color:white" height="5%" bgcolor=blue colspan=2>
          Creado por GVA
        </td>
      </tr> 
    </table>
  </body>
</html>



