
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarPerfilCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    Cliente cli = (Cliente) request.getSession().getAttribute("ClienteSesion");
    
    new ClienteBLL().deleteClienteByDNI(cli);
    request.getSession().removeAttribute("ClienteSesion");
    
    return "/eliminaUsuarioRealizado.jsp";
  }
  
}
