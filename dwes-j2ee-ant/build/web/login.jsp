<%@page import="Presentation.Utilidad.GetterUtil"%>
<form action="Controller?opID=Login" method="POST">
  Nick:
  <input
    type="text"
    name="Nick"
    value="<%=GetterUtil.getInstance().getValue(request, "Nick")%>" 
  />
  <br>
  Password:
  <input 
    type="password" 
    name="Password" 
    value="<%=GetterUtil.getInstance().getValue(request, "Password")%>" 
  />
  <br>
  <input type="submit" value="Entrar" />    
</form>
