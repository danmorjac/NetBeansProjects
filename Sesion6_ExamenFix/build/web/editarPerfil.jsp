
<%@page import="Entidad.Cliente"%>
<%@page import="Presentation.Utilidad.GetterUtil"%>

<h2>Formulario de modificación de usuario</h2>
<form action="Controller?opID=CambiarCliente" method="POST">
    <p>Introduce tu DNI: <input type="text" name="DNI" value="<%=request.getAttribute("DNI")%>" /></p> 
    <p>Introduce tu nombre: <input type="text" name="Nombre" value="<%=GetterUtil.getInstance().getValue(request,"Nombre")%>" /></p>
    <p>Introduce tu primer apellido: <input type="text" name="Apellido1" value="<%=GetterUtil.getInstance().getValue(request,"Apellido1")%>" /></p> 
    <p>Introduce tu segundo apellido: <input type="text" name="Apellido2" value="<%=GetterUtil.getInstance().getValue(request,"Apellido2")%>" /></p> 
    <p>Introduce tu usuario: <input type="text" name="Nick" value="<%=GetterUtil.getInstance().getValue(request,"Nick")%>" /></p> 
    <p>Introduce tu contraseña: <input type="password" name="Password" value="<%=GetterUtil.getInstance().getValue(request,"Password")%>" /></p>
    <p>Introduce tu saldo: <input type="text" name="Saldo" value="<%=GetterUtil.getInstance().getValue(request,"Saldo")%>" /></p> 
     <input type="submit" value="Editar"/> 
</form>

