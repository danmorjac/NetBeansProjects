
package Presentation.Command;

import BLL.ClienteBLL;
import Entidad.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarClienteCommand extends ICommand {

  @Override
  public String execute(
    HttpServletRequest request, HttpServletResponse response
  ) throws Exception {
    
    new ClienteBLL().updateCliente(new Cliente(
      Integer.parseInt(request.getParameter("DNI")),
      request.getParameter("Nombre"),
      request.getParameter("Apellido1"),
      request.getParameter("Apellido2"),
      request.getParameter("Nick"),
      request.getParameter("Password")
    ));
    
    return "/edicionRealizada.jsp";
  }
  
}
