
package Presentation.Command;

import BLL.ClienteBLL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BorrarClienteCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    int DNI = Integer.parseInt((String) request.getSession()
      .getAttribute("borrarClienteDNI"));
    
    new ClienteBLL().deleteClienteByDNI(DNI);
    
    return "/eliminaUsuarioRealizado.jsp";
  }
}
